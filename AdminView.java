package View;

import Controller.BookController;
import Controller.UserController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Olimpiu on 4/23/2017.
 */
public class AdminView {
    private JFrame frame;
    private JTextField textFieldTitle;
    private JTextField textFieldAuthor;
    private JTextField textFieldGenre;
    private JTextField textFieldQuantity;
    private JTextField textFieldPrice;
    private JTextField textFieldNewTitle;
    private JTextField textFieldNewAuthor;
    private JTextField textFieldNewGenre;
    private JTextField textFieldNewQuantity;
    private JTextField textFieldNewPrice;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldType;
    private JTextField textFieldNewUser;
    private JTextField textFieldNewPass;
    private JTextField textFieldNewType;
    private BookController bookController;
    private UserController userController;

    public AdminView() {
        bookController = new BookController();
        userController = new UserController();
        frame = new JFrame();
        frame.setBounds(100, 100, 900, 277);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblBook = new JLabel("Book");
        lblBook.setBounds(10, 11, 46, 14);
        panel.add(lblBook);

        JLabel lblTitle = new JLabel("Title");
        lblTitle.setBounds(10, 36, 46, 14);
        panel.add(lblTitle);

        JLabel lblAuthor = new JLabel("Author");
        lblAuthor.setBounds(10, 61, 46, 14);
        panel.add(lblAuthor);

        JLabel lblGenre = new JLabel("Genre");
        lblGenre.setBounds(10, 86, 46, 14);
        panel.add(lblGenre);

        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(10, 111, 73, 14);
        panel.add(lblQuantity);

        JLabel lblPrice = new JLabel("Price");
        lblPrice.setBounds(10, 136, 46, 14);
        panel.add(lblPrice);

        textFieldTitle = new JTextField();
        textFieldTitle.setBounds(82, 33, 86, 20);
        panel.add(textFieldTitle);
        textFieldTitle.setColumns(10);

        textFieldAuthor = new JTextField();
        textFieldAuthor.setBounds(82, 58, 86, 20);
        panel.add(textFieldAuthor);
        textFieldAuthor.setColumns(10);

        textFieldGenre = new JTextField();
        textFieldGenre.setBounds(82, 83, 86, 20);
        panel.add(textFieldGenre);
        textFieldGenre.setColumns(10);

        textFieldQuantity = new JTextField();
        textFieldQuantity.setBounds(82, 108, 86, 20);
        panel.add(textFieldQuantity);
        textFieldQuantity.setColumns(10);

        textFieldPrice = new JTextField();
        textFieldPrice.setBounds(82, 133, 86, 20);
        panel.add(textFieldPrice);
        textFieldPrice.setColumns(10);

        JButton btnNewBook = new JButton("New Book");
        btnNewBook.setBounds(79, 164, 115, 23);
        panel.add(btnNewBook);
        btnNewBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Update Title");
                String title = textFieldTitle.getText();
                String author = textFieldAuthor.getText();
                String genre = textFieldGenre.getText();
                String quantity = textFieldQuantity.getText();
                String price = textFieldPrice.getText();

                if (!title.equals("") && !author.equals("") && !genre.equals("") && !quantity.equals("") && !price.equals("")) {
                    BookController.addBook(title, author, genre, quantity, price);
                    JOptionPane.showMessageDialog(frame,
                            "Carte adaugata!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JLabel lblNewTitle = new JLabel("New Title");
        lblNewTitle.setBounds(178, 36, 73, 14);
        panel.add(lblNewTitle);

        JLabel lblNewAuthor = new JLabel("New Author");
        lblNewAuthor.setBounds(178, 61, 73, 14);
        panel.add(lblNewAuthor);

        JLabel lblNewGenre = new JLabel("New Genre");
        lblNewGenre.setBounds(178, 86, 73, 14);
        panel.add(lblNewGenre);

        JLabel lblNewQuantity = new JLabel("New Quant.");
        lblNewQuantity.setBounds(178, 111, 73, 14);
        panel.add(lblNewQuantity);

        JLabel lblNewPrice = new JLabel("New Price");
        lblNewPrice.setBounds(178, 136, 73, 14);
        panel.add(lblNewPrice);

        textFieldNewTitle = new JTextField();
        textFieldNewTitle.setBounds(261, 33, 86, 20);
        panel.add(textFieldNewTitle);
        textFieldNewTitle.setColumns(10);

        textFieldNewAuthor = new JTextField();
        textFieldNewAuthor.setBounds(261, 58, 86, 20);
        panel.add(textFieldNewAuthor);
        textFieldNewAuthor.setColumns(10);

        textFieldNewGenre = new JTextField();
        textFieldNewGenre.setBounds(261, 83, 86, 20);
        panel.add(textFieldNewGenre);
        textFieldNewGenre.setColumns(10);

        textFieldNewQuantity = new JTextField();
        textFieldNewQuantity.setBounds(261, 108, 86, 20);
        panel.add(textFieldNewQuantity);
        textFieldNewQuantity.setColumns(10);

        textFieldNewPrice = new JTextField();
        textFieldNewPrice.setBounds(261, 133, 86, 20);
        panel.add(textFieldNewPrice);
        textFieldNewPrice.setColumns(10);

        JButton btnUpdateTitle = new JButton("Update Title");
        btnUpdateTitle.setBounds(357, 32, 122, 23);
        panel.add(btnUpdateTitle);
        btnUpdateTitle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Update Title");
                String oldTitle = textFieldTitle.getText();
                String newTitle = textFieldNewTitle.getText();
                //String r=role.getText();
                if (!oldTitle.equals("") && !newTitle.equals("")) {
                    BookController.updateBook("", "title", oldTitle, newTitle);
                    JOptionPane.showMessageDialog(frame,
                            "Titlu actualizat!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnUpdateAuthor = new JButton("Update Author");
        btnUpdateAuthor.setBounds(357, 57, 122, 23);
        panel.add(btnUpdateAuthor);
        btnUpdateAuthor.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Update Author");
                String newAuthor = textFieldNewAuthor.getText();
                String oldTitle = textFieldTitle.getText();
                //String r=role.getText();
                if (!newAuthor.equals("") && !oldTitle.equals("")) {
                    BookController.updateBook(oldTitle, "author", null, newAuthor);
                    JOptionPane.showMessageDialog(frame,
                            "Autor actualizat!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnUpdateGenre = new JButton("Update Genre");
        btnUpdateGenre.setBounds(357, 82, 122, 23);
        panel.add(btnUpdateGenre);
        btnUpdateGenre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Update Genre");
                //String oldGenre=textFieldGenre.getText();
                String newGenre = textFieldNewGenre.getText();
                String title = textFieldTitle.getText();
                //String r=role.getText();
                if (!newGenre.equals("") && !title.equals("")) {
                    BookController.updateBook(title, "genre", null, newGenre);
                    JOptionPane.showMessageDialog(frame,
                            "Gen actualizat!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnUpdateQuantity = new JButton("Update Quant.");
        btnUpdateQuantity.setBounds(357, 107, 122, 23);
        panel.add(btnUpdateQuantity);
        btnUpdateQuantity.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Update Quantity");
                // String oldQ=textFieldQuantity.getText();
                String newQ = textFieldNewQuantity.getText();
                String title = textFieldTitle.getText();
                //String r=role.getText();
                if (!newQ.equals("") && !title.equals("")) {
                    BookController.updateBook(title, "quantity", null, newQ);
                    JOptionPane.showMessageDialog(frame,
                            "Cantitate actualizata!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnUpdatePrice = new JButton("Update Price");
        btnUpdatePrice.setBounds(357, 132, 122, 23);
        panel.add(btnUpdatePrice);
        btnUpdatePrice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Update Author");
                //String oldPrice=textFieldAuthor.getText();
                String newPrice = textFieldNewAuthor.getText();
                String title = textFieldTitle.getText();
                //String r=role.getText();
                if (!newPrice.equals("") && !title.equals("")) {
                    BookController.updateBook(title, "price", null, newPrice);
                    JOptionPane.showMessageDialog(frame,
                            "Pret actualizat!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnDeleteBook = new JButton("Delete Book");
        btnDeleteBook.setBounds(79, 189, 115, 23);
        panel.add(btnDeleteBook);
        btnDeleteBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //System.out.println("View Client");
                String title = textFieldTitle.getText();
                //String r=role.getText();
                if (!title.equals("")) {
                    bookController.deleteBook(title);
                    JOptionPane.showMessageDialog(frame,
                            "Carte stearsa!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }

            }
        });

        JButton btnListBooks = new JButton("List Books");
        btnListBooks.setBounds(357, 164, 122, 23);
        panel.add(btnListBooks);
        btnListBooks.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JTable table = new JTable(bookController.listAllBooks());
                JOptionPane.showMessageDialog(null, new JScrollPane(table));
            }
        });

        JLabel lblUser = new JLabel("User");
        lblUser.setBounds(514, 11, 46, 14);
        panel.add(lblUser);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(514, 36, 66, 14);
        panel.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(514, 61, 66, 14);
        panel.add(lblPassword);

        JLabel lblType = new JLabel("Type");
        lblType.setBounds(514, 86, 46, 14);
        panel.add(lblType);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(603, 33, 86, 20);
        panel.add(textFieldUsername);
        textFieldUsername.setColumns(10);

        textFieldPassword = new JTextField();
        textFieldPassword.setBounds(603, 58, 86, 20);
        panel.add(textFieldPassword);
        textFieldPassword.setColumns(10);

        textFieldType = new JTextField();
        textFieldType.setBounds(603, 83, 86, 20);
        panel.add(textFieldType);
        textFieldType.setColumns(10);

        JLabel lblNewUsername = new JLabel("New Username");
        lblNewUsername.setBounds(514, 111, 96, 14);
        panel.add(lblNewUsername);

        textFieldNewUser = new JTextField();
        textFieldNewUser.setBounds(603, 108, 86, 20);
        panel.add(textFieldNewUser);
        textFieldNewUser.setColumns(10);

        JLabel lblNewPassword = new JLabel("New Password");
        lblNewPassword.setBounds(514, 136, 86, 14);
        panel.add(lblNewPassword);

        textFieldNewPass = new JTextField();
        textFieldNewPass.setBounds(603, 133, 86, 20);
        panel.add(textFieldNewPass);
        textFieldNewPass.setColumns(10);

        JLabel lblNewType = new JLabel("New Type");
        lblNewType.setBounds(514, 161, 66, 14);
        panel.add(lblNewType);

        textFieldNewType = new JTextField();
        textFieldNewType.setBounds(603, 158, 86, 20);
        panel.add(textFieldNewType);
        textFieldNewType.setColumns(10);

        JButton btnNewUser = new JButton("New User");
        btnNewUser.setBounds(699, 32, 106, 23);
        panel.add(btnNewUser);
        btnNewUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String username = textFieldUsername.getText();
                String password = textFieldPassword.getText();
                String type = textFieldType.getText();
                if (!username.equals("") && !password.equals("") && !type.equals("")) {
                    userController.addUser(username, password, type);
                    JOptionPane.showMessageDialog(frame,
                            "User nou adaugat cu succes!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
                System.out.println("New User");
            }
        });

        JButton btnUpdateUser = new JButton("Update User");
        btnUpdateUser.setBounds(699, 57, 106, 23);
        panel.add(btnUpdateUser);
        btnUpdateUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String username = textFieldUsername.getText();
                String newUser = textFieldNewUser.getText();
                String newPass = textFieldNewPass.getText();
                String newType = textFieldNewType.getText();
                if (!username.equals("") && !newUser.equals("") && !newPass.equals("") && !newType.equals("")) {
                    userController.updateUser(username, newUser, newPass, newType);
                    JOptionPane.showMessageDialog(frame,
                            "User actualizat!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
                System.out.println("New User");
            }
        });

        JButton btnDeleteUser = new JButton("Delete User");
        btnDeleteUser.setBounds(699, 82, 106, 23);
        panel.add(btnDeleteUser);
        btnDeleteUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("Delete User");
                String username = textFieldUsername.getText();

                if (!username.equals("")) {
                    userController.deleteUser(username);
                    JOptionPane.showMessageDialog(frame,
                            "User sters!");
                } else {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!", "Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
                System.out.println("New User");
            }
        });

        JButton btnListUsers = new JButton("List Users");
        btnListUsers.setBounds(699, 107, 106, 23);
        panel.add(btnListUsers);
        frame.setVisible(true);
        btnListUsers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                JTable table = new JTable(userController.listAllUsers());
                JOptionPane.showMessageDialog(null, new JScrollPane(table));
            }
        });

        JButton btnPDF = new JButton("PDF");
        btnPDF.setBounds(699, 132, 106, 23);
        panel.add(btnPDF);
        btnPDF.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                bookController.generateReport("PDF");
                JOptionPane.showMessageDialog(frame,
                        "Raport Creat!");
            }
        });

        JButton btnCSV = new JButton("CSV");
        btnCSV.setBounds(699, 155, 106, 23);
        panel.add(btnCSV);
        btnCSV.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                bookController.generateReport("CSV");
                JOptionPane.showMessageDialog(frame,
                        "Raport Creat!");
            }
        });

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(699, 177, 106, 23);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new LoginView();

            }
        });
        panel.add(btnLogout);
    }
}
