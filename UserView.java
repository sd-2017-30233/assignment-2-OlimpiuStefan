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
public class UserView {
    private JFrame frame;
    private JPanel panel;
    private JTextField textField;
    private BookController bookController;

    public UserView ()
    {
        bookController = new BookController();
        frame = new JFrame();
        frame.setBounds(100, 100, 422, 190);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        String[] patternExamples = {
                "Title",
                "Author",
                "Genre"
        };

        JComboBox comboBox = new JComboBox(patternExamples);
        comboBox.setEditable(false);
        comboBox.setBounds(126, 31, 100, 20);
        panel.add(comboBox);

        JLabel lblSearchBooks = new JLabel("Search Books ");
        lblSearchBooks.setBounds(35, 34, 100, 14);
        panel.add(lblSearchBooks);

        JButton btnSearch = new JButton("Search");
        btnSearch.setBounds(236, 30, 89, 23);
        panel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("search Books");
                String text = comboBox.getSelectedItem().toString();

                if (text.equals("Title")) {
                    JTable table =new JTable(bookController.listBySearchItem("title"));
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                else
                if (text.equals("Author"))
                {
                    JTable table =new JTable(bookController.listBySearchItem("author"));
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
                else
                if (text.equals("Genre"))
                {
                    JTable table =new JTable(bookController.listBySearchItem("genre"));
                    JOptionPane.showMessageDialog(null, new JScrollPane(table));
                }
            }
        });

        JLabel lblBookTitle = new JLabel("Book Title");
        lblBookTitle.setBounds(35, 71, 75, 14);
        panel.add(lblBookTitle);

        textField = new JTextField();
        textField.setBounds(126, 68, 100, 20);
        panel.add(textField);
        textField.setColumns(10);

        JButton btnSell = new JButton("Sell");
        btnSell.setBounds(236, 67, 89, 23);
        panel.add(btnSell);
        btnSell.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String title=textField.getText();
                if (!title.equals("")) {
                    BookController.updateBook(title,"sell",null,null);
                    JOptionPane.showMessageDialog(frame,
                            "Carte vanduta!");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,
                            "Completati campurile corespunzator!","Eroare",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(236, 104, 89, 23);
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispose();
                new LoginView();

            }
        });
        panel.add(btnLogout);

        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        UserView view= new UserView();
    }
}
