import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class palindromeChecker extends JFrame implements ActionListener {
    JTextField numberField;
    JButton checkButton;
    JLabel resultLabel;

    public palindromeChecker(){
        setTitle("Palindrome Checker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setResizable(false);


        JPanel mainPanel = new JPanel(new GridLayout(3,1));
        numberField = new JTextField();
        checkButton = new JButton("Check");
        resultLabel = new JLabel("",SwingConstants.CENTER);

        checkButton.addActionListener(this);

        mainPanel.add(new JLabel("Enter a Number"));
        mainPanel.add(numberField);
        mainPanel.add(checkButton);
        mainPanel.add(resultLabel);

        add(mainPanel);
        setVisible(true);
    }
    public static void main(String[] args) {
        new palindromeChecker();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String numberString = numberField.getText();
        if (numberString.equals("")){
            resultLabel.setText("Please enter a number");

        }
        int number = Integer.parseInt(numberString);
        if (isPalindrome(number)){
            resultLabel.setText(number + " Is a Palindrome");
        }
        else{
            resultLabel.setText(number + " Is not a Palindrome");
        }
    }
    private boolean isPalindrome(int number){
        int originalNumber = number;
        int reverseNumber = 0;
        while (number != 0){
            int digit = number % 10;
            reverseNumber = reverseNumber * 10 + digit;
            number /= 10;
        }
        return originalNumber == reverseNumber;
    }
}