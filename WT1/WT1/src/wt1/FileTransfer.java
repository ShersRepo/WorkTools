/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt1;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import wt1.DefaultLocations.DefaultLocator;

/**
 *
 * @author sher-
 */
public class FileTransfer implements DropTargetListener {
        
    private List<File> fileIntoApp;
    private String locationToDrop;
    
    
    
    
    public FileTransfer(String path){
        locationToDrop = path;
    }
    
    protected void processDrag(DropTargetDragEvent dtde) {
        if (dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
            dtde.acceptDrag(DnDConstants.ACTION_COPY);
        } else {
            dtde.rejectDrag();
        }
    }
    
    public List<File> getTransferredFiles(){
        return this.fileIntoApp;
    }
    
    @Override
    public void dragEnter(DropTargetDragEvent dtde) {
        
    }

    @Override
    public void dragOver(DropTargetDragEvent dtde) {
        System.out.println(locationToDrop);
    }

    @Override
    public void dropActionChanged(DropTargetDragEvent dtde) {
    }

    @Override
    public void dragExit(DropTargetEvent dte) {
    }

    @Override
    public void drop(DropTargetDropEvent dtde) {
        InputStream input = null;
        OutputStream output = null;
        
        Transferable transferable = dtde.getTransferable();
        if(dtde.isDataFlavorSupported(DataFlavor.javaFileListFlavor)){
            dtde.acceptDrop(dtde.getDropAction());
            try{
                List<File> transferData = (List<File>) transferable.getTransferData(DataFlavor.javaFileListFlavor);
                if(transferData != null && transferData.size()> 0){
                    for(File files : transferData){
                        System.out.println(files.getAbsolutePath());
                        System.out.println(locationToDrop);
                        DefaultLocator dl = new DefaultLocator(1);
                        dl.getLocationFile();
                        input = new FileInputStream(files.getAbsoluteFile());
                        String filename = files.getName();
                        output = new FileOutputStream(locationToDrop+"\\"+filename);
                        System.out.println(output);
                        byte[] buffer = new byte[1024];
                        int length;
                        //copy the file content in bytes 
                        while ((length = input.read(buffer)) > 0){
                            output.write(buffer, 0, length);
                        }
                        input.close();
                        output.close();
                    }
                    dtde.dropComplete(true);
                }
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(FileTransfer.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(FileTransfer.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else dtde.rejectDrop();
    }
    
}
