package ru.avalon.java;

import ru.avalon.java.actions.FileCopyAction;
import ru.avalon.java.actions.FileDeleteAction;
import ru.avalon.java.actions.FileMoveAction;
import ru.avalon.java.actions.FileRenameAction;
import ru.avalon.java.console.ConsoleUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Лабораторная работа №3
 * <p>
 * Курс: "Программирование на платформе Java. Разработка
 * многоуровневых приложений"
 * <p>
 * Тема: "Потоки исполнения (Threads) и многозадачность" 
 *
 * @author Daniel Alpatov <danial.alpatov@gmail.com>
 */
public class Lab3 extends ConsoleUI<Commands> {

    private File source;
    private File destination;
    private File movedFile;
    private String newDir;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    /**
     * Точка входа в приложение.
     * 
     * @param args 
     */
    public static void main(String[] args) {

        System.out.println("Print one of the commands: copy, move, delete, rename, exit");
        new Lab3().run();
    }
    /**
     * Конструктор класса.
     * <p>
     * Инициализирует экземпляр базового типа с использоавнием
     * перечисления {@link Commands}.
     */
    Lab3() {
        super(Commands.class);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void onCommand(Commands command) throws IOException {
        switch (command) {
            case copy:
                /*
                 * TODO №6 Обработайте команду copy
                 */

                System.out.println("What to copy? Enter file with all path. ");
                String sourceFile = reader.readLine();
                System.out.println("Enter path to destination file");
                String destinationFile = reader.readLine();

                source = new File (sourceFile);
                destination = new File (destinationFile);

                FileCopyAction copyAction= new FileCopyAction(source,destination);
                copyAction.start();

                break;
            case move:
                /*
                 * TODO №7 Обработайте команду move
                 */

                System.out.println("What to move? Enter file with all path. ");
                String moveFile = reader.readLine();
                System.out.println("Enter path to destination moved file");
                String newDir = reader.readLine();

                movedFile = new File (moveFile);

                FileMoveAction moveAction = new FileMoveAction(movedFile,newDir);
                moveAction.start();

                break;
            case exit:
                close();
                break;
                /*
                 * TODO №9 Обработайте необработанные команды
                 */

            case delete:
                /*
                 * Команда delete
                 */

                System.out.println("What R Y want to delete? Enter file with all path. ");
                String deleteFile = reader.readLine();

                source = new File (deleteFile);
                FileDeleteAction deleteAction = new FileDeleteAction(source);
                deleteAction.start();

                break;

            case rename:
                /*
                 * Команда rename
                 */

                System.out.println("What R Y want to rename? Enter file with all path. ");
                String renameFile = reader.readLine();
                System.out.println("Enter new file name");
                String newName = reader.readLine();

                source = new File (renameFile);
                String newAllfile=source.getParent() + "\\" + newName;
                source.renameTo(new File(newAllfile));
               // FileRenameAction renameAction = new FileRenameAction(source, newName);
               // renameAction.start();
              //  source.getParent(),newName

                break;
        }
    }
    
}