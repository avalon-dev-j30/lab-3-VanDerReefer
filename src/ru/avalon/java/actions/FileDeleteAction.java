package ru.avalon.java.actions;

import java.io.File;

public class FileDeleteAction implements Action {

    private File deleted;

    public FileDeleteAction(File deleted) {
        this.deleted = deleted;
    }

    public synchronized void deleteFile(){
        deleted.delete();
    }

    @Override
    public void run() {
        deleteFile();
    }

    @Override
    public void close() throws Exception {

    }
}