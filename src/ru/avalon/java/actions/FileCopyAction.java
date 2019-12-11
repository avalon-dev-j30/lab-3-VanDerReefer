package ru.avalon.java.actions;

import java.io.*;
import java.nio.file.Files;

/**
 * Действие, которое копирует файлы в пределах дискового
 * пространства.
 */
public class FileCopyAction implements Action {
    /**
     * {@inheritDoc}
     */
   private File source;
   private File destination;



    public FileCopyAction(File source, File destination){
        this.source = source;
        this.destination = destination;

    }

    private synchronized void copyFile() throws IOException {


        try(InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
    }

    @Override
    public void run() {
        /*
         * TODO №2 Реализуйте метод run класса FileCopyAction
         */
        try {
            copyFile();
        } catch (IOException e) {
            e.printStackTrace();
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

    }
}