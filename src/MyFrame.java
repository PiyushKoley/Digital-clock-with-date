import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import static java.lang.Thread.sleep;
public class MyFrame extends JFrame implements ActionListener {
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    JButton button_12hr;
    JButton button_24hr;
    SimpleDateFormat timeFormat;
    SimpleDateFormat twentyFourFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    String time;
    String day;
    String date;
    int i=1;
    MyFrame() throws InterruptedException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Clock");
        this.setSize(300,250);
        this.setLayout(new FlowLayout());
        this.setResizable(false);

        button_12hr = new JButton("12Hr FORMAT");
        button_12hr.addActionListener(this);
        button_12hr.setFocusable(false);
        button_12hr.setEnabled(false);
        this.add(button_12hr);

        button_24hr = new JButton("24Hr FORMAT");
        button_24hr.addActionListener(this);
        button_24hr.setFocusable(false);
        button_24hr.setEnabled(true);
        this.add(button_24hr);

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("AvantGarde",Font.PLAIN,50));
        timeLabel.setBackground(Color.BLACK);
        timeLabel.setForeground(new Color(0x4f432));
        timeLabel.setBorder(BorderFactory.createBevelBorder(1));
        timeLabel.setOpaque(true);
        this.add(timeLabel);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("SansSerif",Font.PLAIN,35));
        this.add(dayLabel);

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("TimesNewRoman",Font.PLAIN,25));
        this.add(dateLabel);

        this.setVisible(true);
        twentyFourFormat = new SimpleDateFormat("HH:mm:ss");
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        dayFormat = new SimpleDateFormat("EEEE");
        dateFormat = new SimpleDateFormat("MMMMM d, yyyy");

        setTimenow();
    }
    public void setTimenow() throws InterruptedException {
        while(true) {
            if(i==1) {
                time = timeFormat.format(Calendar.getInstance().getTime());
                timeLabel.setText(time.toUpperCase());
            }
            else{
                time = twentyFourFormat.format(Calendar.getInstance().getTime());
                time = time + " hr";
                timeLabel.setText(time.toUpperCase());
            }
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

            sleep(1000);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button_24hr){
//            System.out.println("button_24hr is pressed");
            button_24hr.setEnabled(false);
            button_12hr.setEnabled(true);
            i = 0;

        }
        else if(e.getSource()==button_12hr){
//            System.out.println("button_12hr is pressed");
            button_12hr.setEnabled(false);
            button_24hr.setEnabled(true);
            i = 1;
        }
    }

}
