package ru.avalon.java.actions;

import java.nio.file.Path;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */

public class FileCopyAction implements Action {
    
    private Path sourcePath;
    private Path destinationPath;

    public FileCopyAction(Path sourcePath, Path destinationPath) {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
    }
    
   @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        
        
        throw new UnsupportedOperationException("Not implemented yet!");

    @Override
    public void start() {
        Action.super.start(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void close() throws Exception {
        /*
         * TODO №3 Реализуйте метод close класса FileCopyAction
         */
        throw new UnsupportedOperationException("Not implemented yet!");
    }
}
