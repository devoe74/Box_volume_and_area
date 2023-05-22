import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    public static final int WINDOW_WIDTH = 810;
    public static final int WINDOW_HEIGHT = 500;

    private String sWidth;
    private String sHeight;
    private String sLength;
    private double height;
    private double width;
    private double length;
    private double area;
    private double volume;
    TextField widthData;
    TextField heightData;
    TextField lengthData;
    JLabel volumeText;
    JLabel areaText;
    JDialog errorsDialog;
    JLabel errors;
    Integer pressed = null;
    boolean canShowAnswer;
    public JButton button = new JButton("Calculate");

    public Window() {

        this.setResizable(false);
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Box volume & area");
        this.setLayout(null);

        canShowAnswer = true;


        Font font1 = new Font("Ariel", Font.PLAIN, 30);
        Font font2 = new Font("Ariel", Font.PLAIN, 20);

        this.errorsDialog = new JDialog();
        this.errors = new JLabel();


        JLabel widthText = new JLabel("enter width: ");
        widthText.setBounds(50, 50, 200, 40);
        widthText.setFont(font1);
        this.add(widthText);

        widthData = new TextField();
        widthData.setBounds(400, 50, 200, 40);
        widthData.setFont(font1);
        this.add(widthData);


        JLabel heightText = new JLabel("enter height: ");
        heightText.setBounds(50, 150, 200, 40);
        heightText.setFont(font1);
        this.add(heightText);

        heightData = new TextField();
        heightData.setBounds(400, 150, 200, 40);
        heightData.setFont(font1);
        this.add(heightData);

        JLabel lengthText = new JLabel("enter length: ");
        lengthText.setBounds(50, 250, 200, 40);
        lengthText.setFont(font1);
        this.add(lengthText);

        lengthData = new TextField();
        lengthData.setBounds(400, 250, 200, 40);
        lengthData.setFont(font1);
        this.add(lengthData);

        collectData();

        areaText = new JLabel();
        areaText.setBounds(290, 400, 230, 40);
        areaText.setFont(font2);
        this.add(areaText);

        volumeText = new JLabel();
        volumeText.setBounds(530, 400, 250, 40);
        volumeText.setFont(font2);
        this.add(volumeText);


    }


    public void collectData() {
        button.setBounds(50, 350, 150, 60);
        button.addActionListener((e -> {
            this.sWidth = widthData.getText();
            this.sHeight = heightData.getText();
            this.sLength = lengthData.getText();

            try {
                this.width = Double.parseDouble(sWidth);
            } catch (NumberFormatException e1) {
                System.out.println(e1.getMessage());
                JOptionPane.showMessageDialog(this, "invalid width!");
                this.errors.setText(e1.getMessage());
                canShowAnswer = false;
            }
            try {
                this.height = Double.parseDouble(sHeight);
            } catch (NumberFormatException e2) {
                System.out.println(e2.getMessage());
                JOptionPane.showMessageDialog(this, "invalid height!");
                this.errors.setText(e2.getMessage());
                canShowAnswer = false;
            }
            try {
                this.length = Double.parseDouble(sLength);
            } catch (NumberFormatException e3) {
                System.out.println(e3.getMessage());
                JOptionPane.showMessageDialog(this, "invalid length!");
                this.errors.setText(e3.getMessage());
                canShowAnswer = false;
            }


            System.out.println(sWidth);
            System.out.println(sHeight);
            System.out.println(sLength);

            Calculate calculate = new Calculate();
            if (canShowAnswer) {
                this.area = calculate.calculateArea(this.height, this.width, length);
                this.volume = calculate.calculateVolume(this.height, this.width, length);
            }
            canShowAnswer = true;
            String s = String.valueOf(area);
            System.out.println(area );
            System.out.println(volume);
            this.areaText.setText("area: " + String.format("%.4f", area));
            this.volumeText.setText("volume:" + String.format("%.4f", volume));

            errorsDialog.add(errors);


        }));
        this.add(button);

    }


    public void showWindow() {
        this.setVisible(true);
    }
}

