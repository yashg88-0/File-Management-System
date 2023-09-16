import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class FileHandler extends JFrame {

    private static final String BASE_DIRECTORY = "C:\\Yash\\";

    private JTextField fileNameField;
    private JTextArea fileContentArea;

    public FileHandler() {
        super("File Handler");

        fileNameField = new JTextField(20);
        fileContentArea = new JTextArea(10, 40);

        JButton createButton = new JButton("Create");
        JButton readButton = new JButton("Read");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createFile();
            }
        });

        readButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readFile();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFile();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFile();
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("File Name:"), BorderLayout.WEST);
        panel.add(fileNameField, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(createButton);
        buttonPanel.add(readButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        setLayout(new BorderLayout());
        add(panel, BorderLayout.NORTH);
        add(new JScrollPane(fileContentArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void createFile() {
        String fileName = fileNameField.getText();
        String content = fileContentArea.getText();

        if (!fileName.isEmpty()) {
            try (FileWriter fw = new FileWriter(BASE_DIRECTORY + fileName + ".txt")) {
                fw.write(content);
                showMessageDialog("File Created Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                showMessageDialog("Error Creating File.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessageDialog("Please Enter a File Name.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void readFile() {
        String fileName = fileNameField.getText();
        if (!fileName.isEmpty()) {
            try (Scanner fileScanner = new Scanner(new File(BASE_DIRECTORY + fileName + ".txt"))) {
                StringBuilder content = new StringBuilder();
                while (fileScanner.hasNextLine()) {
                    content.append(fileScanner.nextLine()).append("\n");
                }
                fileContentArea.setText(content.toString());
                showMessageDialog("File Read Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException e) {
                showMessageDialog("File not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessageDialog("Please Enter a File Name.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void updateFile() {
        String fileName = fileNameField.getText();
        String content = fileContentArea.getText();

        if (!fileName.isEmpty()) {
            try (FileWriter fw = new FileWriter(BASE_DIRECTORY + fileName + ".txt", false)) {
                fw.write(content);
                showMessageDialog("File Updated Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                showMessageDialog("Error Updating File.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessageDialog("Please Enter a File Name.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void deleteFile() {
        String fileName = fileNameField.getText();
        if (!fileName.isEmpty()) {
            File fileToDelete = new File(BASE_DIRECTORY + fileName + ".txt");
            if (fileToDelete.exists() && fileToDelete.delete()) {
                showMessageDialog("File Deleted Successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                fileNameField.setText("");
                fileContentArea.setText("");
            } else {
                showMessageDialog("File not found or could not be deleted.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            showMessageDialog("Please Enter a File Name.", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void showMessageDialog(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FileHandler();
            }
        });
    }
}
