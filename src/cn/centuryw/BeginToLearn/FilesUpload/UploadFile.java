package cn.centuryw.BeginToLearn.FilesUpload;

import java.io.File;

/**
 * 要上传的文件
 */
public class UploadFile {
    public File file;
    /**
     * @param file 要上传的文件路径
     */
    public UploadFile(File file){
        this.file = file;
    }
}
