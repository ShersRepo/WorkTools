/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt1;

/**
 *
 * @author sher-
 */
public class FolderCheck {
    private String customer;
    private String workingFile;
    private String printedFrom;
    private String doNotUse;
    private String guides;
    private String books;
    
    public String getFolder(int folderNo){
        String result = "";
        
        if(folderNo == 0){
            result = "Customer";
        } else if(folderNo == 1){
            result = "Working Folder";
        } else if(folderNo == 2){
        result = "Printed From";
        } else if (folderNo == 3){
            result = "Do Not Use";
        } else if (folderNo == 4){
            result = "Guides";
        } else if (folderNo == 5){
            result = "Books";
        }
        return result;
    }
}
