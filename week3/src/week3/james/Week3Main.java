package week3.james;

/**
 * author:james
 * date: 2020-06-22
 */
public class Week3Main {
    public static void main(String[] args) {

        Lable lblUser = new Lable("用户名");
        TextBox txtUser = new TextBox("文本框");
        Lable lblPwd = new Lable("密码");
        PasswordBox txtPass = new PasswordBox("密码框");
        Lable lblRemember = new Lable("复选框");
        CheckBox chkRemember = new CheckBox("记住用户名");
        LinkLable linkLable = new LinkLable("忘记密码");

        Frame frame = new Frame("FRAM1");
        frame.addComponent(lblUser);
        frame.addComponent(txtUser);
        frame.addComponent(lblPwd);
        frame.addComponent(txtPass);
        frame.addComponent(lblRemember);
        frame.addComponent(chkRemember);
        frame.addComponent(linkLable);

        Picture picture  = new Picture("LOGO图片");
        Button btnLogo = new Button("登录");
        Button btnReg = new Button("注册");

        WinForm winForm = new WinForm("WINDOWS窗口");
        winForm.addComponent(picture);
        winForm.addComponent(btnLogo);
        winForm.addComponent(btnReg);
        winForm.addComponent(frame);

        winForm.Print();


    }
}
