package com.sha.model;

import com.sha.util.FileUtil;

public class Image extends BaseModel implements IFileDirectory{

    private static final long serialVersionUID = 1L;

    private String filename;

    private int width;

    private int height;

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public boolean isFileExist(){
        return FileUtil.isFileExist(filename);
    }

    @Override
    public boolean isFile(){
        return FileUtil.isFile(filename);
    }
}
