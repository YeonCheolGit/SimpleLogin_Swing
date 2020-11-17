import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Function extends JFrame implements ActionListener {

    JPanel panel;
    JLabel message;
    JButton submit;

    Function() {

        // 로그인 한 아이디 보여 줄 message 변수
        message = new JLabel();
        message.setFont(new Font("Serif", Font.BOLD, 25));

        // 메인 화면 레이아웃 생성
        panel = new JPanel(new GridLayout(3, 1));

        // 첫 메인 화면 로그인 버튼
        submit = new JButton("로그인");
        submit.setFont(new Font("DIALOG", Font.BOLD, 25));

        // panel에 화면 구성 추가
        panel.add(message);
        panel.add(submit);

        // 로그인 버튼 클릭 시 Listener 작동
        submit.addActionListener(this);

        // 전체 윈도우 레이아웃 구성
        add(panel, BorderLayout.CENTER);
        setTitle("로그인 폼");
        setSize(500, 250);
        setVisible(true);

        // 윈도우 창 닫을 시 프로세스 종료
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    /*
    1. 로그인 버튼 클릭
    2. 아이디에 admin을 입력 시 관리자 계정
    3. 비밀번호 != admin 경우 다시 로그인 하라는 창 발생
    4. 비밀번호 == admin 경우 메인 화면으로 아이디와 함께 넘어감
    5. 관리자 계정 아닐 경우 검증 없이 바로 로그인
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String userName;
        String password;
        boolean check = false;

        userName = JOptionPane.showInputDialog("아이디를 입력하세요.");
           if (userName.trim().equals("admin")) {
               password = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
               if (password.trim().equals("admin")) {
                    check = true;
                   JOptionPane.showConfirmDialog(null, "관리자 계정으로 로그인하셨습니다.", "메세지", JOptionPane.YES_NO_OPTION);
                   message.setText(userName + "님");
               } else {
                   do {
                       if (password.trim().equals("admin")) {
                           JOptionPane.showConfirmDialog(null, "관리자 계정으로 로그인하셨습니다.", "메세지", JOptionPane.YES_NO_OPTION);
                           check = true;
                           message.setText(userName + "님");
                           break;
                       } else {
                           JOptionPane.showConfirmDialog(null, "관리자 계정 비밀번호가 틀렸습니다.", "메세지", JOptionPane.YES_NO_OPTION);
                           password = JOptionPane.showInputDialog("비밀번호를 다시 입력하세요.");
                           check = false;
                       }
                   } while (check = true);
               }
           } else {
               password = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
               JOptionPane.showConfirmDialog(null, "안녕하세요 " + userName + "님", "메세지", JOptionPane.YES_NO_OPTION);
               message.setText(userName + "님");
           }
    }
}
