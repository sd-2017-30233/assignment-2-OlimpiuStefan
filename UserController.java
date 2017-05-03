package Controller;

import Model.User;
import XML.XmlParser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Olimpiu on 4/23/2017.
 */
public class UserController {

    public ArrayList<User> findAllUsers() {
        ArrayList<User> users = new ArrayList<User>();
        NodeList nList = XmlParser.getNodeListByTag("users.xml", "user");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                User user = new User();
                user.setId(eElement.getAttribute("id"));
                user.setUsername(eElement.getElementsByTagName("username").item(0).getTextContent());
                user.setPassword(eElement.getElementsByTagName("password").item(0).getTextContent());
                user.setType(eElement.getElementsByTagName("type").item(0).getTextContent());
                users.add(user);
            }
        }
        return users;
    }

    public static DefaultTableModel buildBooksTable(ArrayList<User> list) {

        String[] columnNames = {
                "Username",
                "Password",
                "Type"};

        Object[][] array = new Object[list.size()][];
        int i = 0;
        for (User c : list) {
            array[i] = new Object[3];
            array[i][0] = c.getUsername();
            array[i][1] = c.getPassword();
            array[i][2] = c.getType();
            i++;
        }
        return new DefaultTableModel(array, columnNames);
    }

    public DefaultTableModel listAllUsers() {

        ArrayList<User> users = findAllUsers();
        return buildBooksTable(users);
    }

    public void updateUser(String oldUsername, String newUsername, String password, String type) {
        NodeList users = XmlParser.getNodeListByTag("users.xml", "user");
        Element user;
        for (int i = 0; i < users.getLength(); i++) {
            user = (Element) users.item(i);
            String username = user.getElementsByTagName("username").item(0).getTextContent();
            if (username.equals(oldUsername)) {
                Node newUser = user.getElementsByTagName("username").item(0).getFirstChild();
                Node newPass = user.getElementsByTagName("password").item(0).getFirstChild();
                Node newType = user.getElementsByTagName("type").item(0).getFirstChild();
                newUser.setNodeValue(newUsername);
                newPass.setNodeValue(password);
                newType.setNodeValue(type);
            }
        }
        XmlParser.updateXML("users.xml");
    }

    public void addUser(String inputUsername, String inputPassword, String inputType) {
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse("users.xml");
            Element root = document.getDocumentElement();

            Element newUser = document.createElement("user");

            Element username = document.createElement("username");
            username.appendChild(document.createTextNode(inputUsername));
            newUser.appendChild(username);

            Element password = document.createElement("password");
            password.appendChild(document.createTextNode(inputPassword));
            newUser.appendChild(password);

            Element type = document.createElement("type");
            type.appendChild(document.createTextNode(inputType));
            newUser.appendChild(type);

            root.appendChild(newUser);

            DOMSource source = new DOMSource(document);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            StreamResult result = new StreamResult("users.xml");
            transformer.transform(source, result);
        } catch (org.xml.sax.SAXException saxe1) {
            saxe1.printStackTrace();
        } catch (ParserConfigurationException pce1) {
            pce1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (TransformerException te1) {
            te1.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getLoginUser(String username, String password) {
        String loginUser = "";
        NodeList users = XmlParser.getNodeListByTag("users.xml", "user");
        Element user = null;
        for (int i = 0; i < users.getLength(); i++) {
            user = (Element) users.item(i);
            String userFromList = user.getElementsByTagName("username").item(0).getTextContent();
            if (userFromList.equals(username)) {
                String passFromList = user.getElementsByTagName("password").item(0).getTextContent();
                if (passFromList.equals(password))
                    loginUser = user.getElementsByTagName("type").item(0).getTextContent();
            }
        }
        return loginUser;
    }

    public void deleteUser(String username) {
        NodeList nList = XmlParser.getNodeListByTag("users.xml", "user");
        for (int i = 0; i < nList.getLength(); i++) {
            Element user = (Element) nList.item(i);
            Element usernameFromList = (Element) user.getElementsByTagName("username").item(0);
            String pName = usernameFromList.getTextContent();
            if (pName.equals(username)) {
                user.getParentNode().removeChild(user);
            }
        }
        XmlParser.updateXML("users.xml");
    }

    public static void main(String[] args) {
        UserController bc = new UserController();
        ArrayList<User> users = bc.findAllUsers();

        for (int i = 0; i < users.size(); i++) {
            System.out.println(users.get(i).getUsername());
        }
        System.out.println(bc.getLoginUser("Calin", "Test123."));
        //updateUser("asd","Ionut","Bora","user");
    }
}
