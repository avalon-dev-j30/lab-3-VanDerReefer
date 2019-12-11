package ru.avalon.java.actions;

import java.io.File;

/**
 * Действие, которое перемещает файлы в пределах дискового
 * пространства.
 */
public class FileMoveAction implements Action {
    /**
     * {@inheritDoc}
     */
    private File movedFile;
    private String newDir;

    public FileMoveAction(File movedFile, String newDir) {
        this.movedFile = movedFile;
        this.newDir=newDir;
    }

    public synchronized void moveFile() {
        movedFile.renameTo(new File(newDir, movedFile.getName()));
    }

    @Override
    public void run() {
        /*
         * TODO №4 Реализуйте метод run класса FileMoveAction
         */
        moveFile();
    }

    /**
     * {@inheritDoc}
     */
        /*
         * TODO №5 Реализуйте метод close класса FileMoveAction
         */
    @Override
    public void close() throws Exception {

}

}