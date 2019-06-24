import javax.swing.JFrame;

public class GuiApplication extends JFrame {

  private MenuPanel menuPanel;

  private ContentPanel contentPanel;

  GuiApplication(String accessToken, String tokenType, Integer expirationTime,
      String refreshToken) {
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // getContentPane().add (new MenuPanel());
    //getContentPane().add(new ContentPanel());
    setLayout(null);

    this.contentPanel = new ContentPanel(this);
    this.menuPanel = new MenuPanel(this);

    this.menuPanel.setBounds(0, 0, 944, 150);
    this.contentPanel.setBounds(0, 155, 944, 413);

    this.add(menuPanel);
    this.add(contentPanel);

    this.setBounds(100, 100, 944, 563);
    this.setBounds(100, 100, 1000, 650);

    setVisible(true);
  }

  public MenuPanel getMenuPanel() {
    return menuPanel;
  }

  public void setMenuPanel(MenuPanel menuPanel) {
    this.menuPanel = menuPanel;
  }

  public ContentPanel getContentPanel() {
    return contentPanel;
  }

  public void setContentPanel(ContentPanel contentPanel) {
    this.contentPanel = contentPanel;
  }

  public JFrame getFrame() {
    return this;
  }
}
