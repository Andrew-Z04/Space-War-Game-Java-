import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class Board extends JPanel implements ActionListener {
    private final int WIDTH = 500;
    private final int HEIGHT = 500;
    private final int SQUARE_SIZE = 40;
    private final Player player = new Player();
    private Boss1 boss1 = new Boss1();
    private final List<RepairBox> repairBoxes = new ArrayList<>();
    private final List<Enemy> enemies = new ArrayList<>();
    private final List<Bullet> bullets = new ArrayList<>();
    private final List<EnemyBullet> enemyBullets = new ArrayList<>();
    private final List<EnemyBoss1Bullet> enemyBoss1Bullets = new ArrayList<>();
    private boolean inGame = true;
    private boolean pauze = false;
    private boolean gameOver = false;
    private final boolean startMenu = true;
    private boolean playerDefeatBoss1 = false;
    private Image img;
    private Image img2;
    private Image img3;
    private Image img4;
    private Image img5;
    public int killedEnemy = 0;
    public int killedEnemyScore = 0;
    public int money = 0;
    public int bonusMoney1 = 0;
    public int defeatBoss1Cash = 0;
    public int live  = 6;
    public int boss1Live = 10;
    public int score = 0;
    public int reloadBossAmmo = 0;
    public int reloadBossAmmoSpeed = 37;
    public boolean wedlugX = false;
    public boolean doDolu = false;
    private int strzalka_w_prawo_x;
    private int strzalka_w_prawo_y;
    private int strzalka_w_lewo_x;
    private int strzalka_w_lewo_y;
    private int pozycjaStrzalek = 1;
    public int jednorazowka = 0;
    private boolean spawnBoss1 = false;
    public Board(){
        initBoard();
        loadImage();
    }
    private void initBoard(){
        addKeyListener(new TAdapter());
        setBackground(Color.BLUE);
        setFocusable(true);
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        initGame();
    }
    private void initGame(){
        int DELAY = 7;
        Timer timer = new Timer(DELAY, this);
        timer.start();
        if (inGame) {
            repairBoxes.add(new RepairBox());
            enemies.add(new Enemy());
            enemies.add(new Enemy());
            for (Enemy enm : enemies) {
                enemyBullets.add(enm.shoot());
            }
        }
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
    private int h, w;
    public Image getImg(){
        return img;
    }
    public Image getImg2(){
        return img2;
    }
    public Image getImg3(){
        return img3;
    }
    public Image getImg4(){
        return img4;
    }
    public Image getImg5(){
        return img5;
    }
    private void loadImage(){
        ImageIcon ii = new ImageIcon("src/Image/SpaceWarKosmos.png");
        img = ii.getImage();
        ImageIcon ii2 = new ImageIcon("src/Image/Tabela.png");
        img2 = ii2.getImage();
        ImageIcon ii3 = new ImageIcon("src/Image/Menu_Space-War.png");
        img3 = ii3.getImage();
        ImageIcon ii4 = new ImageIcon("src/Image/strzalka_w_prawo.png");
        img4 = ii4.getImage();
        ImageIcon ii5 = new ImageIcon("src/Image/strzalka_w_lewo.png");
        img5 = ii5.getImage();
        w=img.getWidth(null);
        h=img.getHeight(null);
    }
    private void doDrawing(Graphics g){
        if (startMenu) {
            if(pozycjaStrzalek >= 5){
                pozycjaStrzalek = 1;
            }
            if(pozycjaStrzalek <= 0){
                pozycjaStrzalek = 4;
            }
            if (pozycjaStrzalek == 1){
                strzalka_w_prawo_x = 130;
                strzalka_w_prawo_y = 190;
                strzalka_w_lewo_x = 330;
                strzalka_w_lewo_y = 190;
            }
            if (pozycjaStrzalek == 2){
                strzalka_w_prawo_x = 130;
                strzalka_w_prawo_y = 240;
                strzalka_w_lewo_x = 330;
                strzalka_w_lewo_y = 240;
            }
            if (pozycjaStrzalek == 3){
                strzalka_w_prawo_x = 130;
                strzalka_w_prawo_y = 290;
                strzalka_w_lewo_x = 330;
                strzalka_w_lewo_y = 290;
            }
            if (pozycjaStrzalek == 4){
                strzalka_w_prawo_x = 130;
                strzalka_w_prawo_y = 340;
                strzalka_w_lewo_x = 330;
                strzalka_w_lewo_y = 340;
            }
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(this.getImg3(), 0, 0, this);
            g2d.drawImage(this.getImg4(),strzalka_w_prawo_x,strzalka_w_prawo_y,this);
            g2d.drawImage(this.getImg5(),strzalka_w_lewo_x,strzalka_w_lewo_y,this);
        }
        if(inGame){
            Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(this.getImg(),0 ,0, this);
            g2d.drawImage(this.getImg2(),0 ,460, this);
            g2d.drawImage(player.getImg(), player.getPlayerX(), player.getPlayerY(),this);
            Font text = new Font ( "Helvetica", Font.BOLD, 30);
            g.setColor(Color.WHITE);
            g.setFont(text);
            g.drawString("SCORE",5,491);
            g.drawString("LIVE",160,491);
            g.drawString("MONEY",275,491);
            g.setColor(Color.BLACK);
            g.drawString(""+ score, 120,491);
            g.drawString(""+ live, 235,491);
            g.drawString(""+ money,390,491);
            if(pauze){
                Font text2 = new Font ( "Helvetica", Font.BOLD, 70);
                g.setFont(text2);
                g.setColor(Color.BLACK);
                g.drawString("PAUZE", 160,250);
            }
            if (spawnBoss1 || boss1 != null) {
                g2d.drawImage(boss1.getImg(), boss1.getBoss1_x(), boss1.getBoss1_y(), this);
            }
            for (Enemy enemy : enemies) {
                if (enemy != null) {
                    g2d.drawImage(enemy.getImg(), enemy.getEnemyX(), enemy.getEnemyY(), this);
                }
            }
            if(live < 10) {
                for (RepairBox repairBox : repairBoxes) {
                    if (repairBox != null)
                        g2d.drawImage(repairBox.getImg(), repairBox.getRepairBoxX(), repairBox.getRepairBoxY(), this);
                }
            }
            for (Bullet b : bullets) {
                if(b != null){
                    g.setColor(Color.RED);
                    g.fillRect(b.getBulletX(), b.getBulletY(), 6, 4);
                }
            }
            for (EnemyBullet eb : enemyBullets) {
                if (eb != null) {
                    g.setColor(Color.RED);
                    g.fillRect(eb.getEnemyBulletX(), eb.getEnemyBulletY(), 6, 4);
                }
            }
            for (EnemyBoss1Bullet ebb : enemyBoss1Bullets) {
                if (ebb != null) {
                    g.setColor(Color.GREEN);
                    g.fillOval(ebb.getEnemyBoss1Bullet_x(), ebb.getEnemyBoss1Bullet_y(), ebb.getEnemyBoss1BulletWidth(), ebb.getEnemyBoss1BulletHeight());
                }
            }
        }
        if (gameOver) {
                gameOver(g);
        }
    }
    private void gameOver (Graphics g){
        Font text = new Font ( "Helvetica", Font.BOLD, 12);
        FontMetrics metr = getFontMetrics(text);
        g.setColor(Color.WHITE);
        g.setFont(text);
        g.drawString("GAME OVER", (WIDTH- metr.stringWidth("GAME OVER"))/2, HEIGHT /2);
        g.drawString("SCORE"+" :"+ score, 330,320);
    }
    private void enemyMove() {
        for (Enemy enemy : enemies) {
            if (enemy != null) enemy.setEnemy_x(enemy.getEnemyX() - 2);
        }
        for(int i =0;i < enemies.size(); i++) {
            if (enemies.get(i) != null){
                if (enemies.get(i).getEnemyX() == 0) {
                    Enemy en4 = new Enemy();
                    enemies.add(en4);
                    enemyBullets.add(en4.shoot());
                }
            }
        }
    }
    private void moveBoss1(){
        if (boss1.getBoss1_x() == 420){
            jednorazowka = 1;
            wedlugX = true;
        }
        if (boss1.getBoss1_x() == 420 || jednorazowka > 0 || wedlugX) {
        } else {
            boss1.setBoss1_x(boss1.getBoss1_x() - 2);
        }
        if (wedlugX) {
            if (boss1.getBoss1_y() == 0) {
                doDolu  = true;
            }
            if (boss1.getBoss1_y() + 80 == 460) {
                doDolu = false;
            }
            if (doDolu){
                boss1.setBoss1_y(boss1.getBoss1_y() + 2);
                reloadBossAmmo++;
            }
            if (doDolu == false){
                boss1.setBoss1_y(boss1.getBoss1_y() - 2);
                reloadBossAmmo++;
            }
        }
        if (reloadBossAmmo / reloadBossAmmoSpeed  >= 1){
            enemyBoss1Bullets.add(boss1.shoot());
            enemyBoss1Bullets.add(boss1.shoot());
            reloadBossAmmo = 0;
        }
    }
    private void checkCollision() {
        if (live <= 0){gameOver = true; inGame = false;}
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < enemies.size(); j++) {
                Enemy en = enemies.get(j);
                if (en != null && bullets.get(i) != null) {
                    if (bullets.get(i).getBulletX() >= en.getEnemyX() && bullets.get(i).getBulletX() <= en.getEnemyX() + SQUARE_SIZE && bullets.get(i).getBulletY() >= en.getEnemyY() && bullets.get(i).getBulletY() <= en.getEnemyY() + SQUARE_SIZE) {
                        bullets.set(i, null);
                        enemies.set(j, null);
                        killedEnemyScore++;
                        killedEnemy++;
                        score++;
                        money++;
                        money++;
                    }
                }
            }
        }
        for (int i = 0; i < enemyBullets.size(); i++) {
            EnemyBullet enb = enemyBullets.get(i);
            if (enb != null) {
                if (enemyBullets.get(i).getEnemyBulletX() >= player.getPlayerX() && enemyBullets.get(i).getEnemyBulletX() <= player.getPlayerX() + SQUARE_SIZE && enemyBullets.get(i).getEnemyBulletY() >= player.getPlayerY() && enemyBullets.get(i).getEnemyBulletY() <= player.getPlayerY() + SQUARE_SIZE) {
                    enemyBullets.set(i, null);
                    live--;
                }
            }
        }
        for (int i = 0; i < enemyBoss1Bullets.size(); i++) {
            EnemyBoss1Bullet ebb = enemyBoss1Bullets.get(i);
            if (ebb != null) {
                if (enemyBoss1Bullets.get(i).getEnemyBoss1Bullet_x() >= player.getPlayerX() && enemyBoss1Bullets.get(i).getEnemyBoss1Bullet_x()/* + enemyBoss1Bullets.get(i).getEnemyBoss1BulletWidth()*/ <= player.getPlayerX() + SQUARE_SIZE && enemyBoss1Bullets.get(i).getEnemyBoss1Bullet_y() + enemyBoss1Bullets.get(i).getEnemyBoss1BulletHeight() >= player.getPlayerY() && enemyBoss1Bullets.get(i).getEnemyBoss1Bullet_y() <= player.getPlayerY() + SQUARE_SIZE) {
                    enemyBoss1Bullets.set(i, null);
                    live--;
                }
            }
        }
        for (int i = 0; i < bullets.size(); i++) {
            for (int h = 0; h < repairBoxes.size(); h++) {
                if (bullets.get(i) != null) {
                    if (bullets.get(i).getBulletX() >= repairBoxes.get(h).getRepairBoxX() && bullets.get(i).getBulletX() <= repairBoxes.get(h).getRepairBoxX() + SQUARE_SIZE && bullets.get(i).getBulletY() >= repairBoxes.get(h).getRepairBoxY() && bullets.get(i).getBulletY() <= repairBoxes.get(h).getRepairBoxY() + SQUARE_SIZE) {
                        bullets.set(i, null);
                        repairBoxes.get(h).setRepairBox_x((int) (Math.random() * 420));
                        repairBoxes.get(h).setRepairBox_y((int) (Math.random() * 420));
                    }
                }
            }
        }
        for (int i = 0; i < bullets.size(); i++) {
            if (boss1 == null || bullets.get(i) == null || player == null || !spawnBoss1) {
                continue;
            }
            if (bullets.get(i).getBulletX() >= boss1.getBoss1_x() && bullets.get(i).getBulletX() <= boss1.getBoss1_x() + 80 && bullets.get(i).getBulletY() >= boss1.getBoss1_y() && bullets.get(i).getBulletY() <= boss1.getBoss1_y() + 80) {
                bullets.set(i, null);
                boss1Live--;
            }
        }
    }
    private void moveBullets(){
        bullets.stream().filter(Objects::nonNull).forEach(Bullet::move);
        for (EnemyBullet eb : enemyBullets) {
            if (eb != null)
                eb.move();
        }
        for (EnemyBoss1Bullet ebb : enemyBoss1Bullets) {
            if (ebb != null)
                ebb.move();
        }
        for (int i = 0; i < enemyBullets.size(); i++) {
            if (enemyBullets.get(i) != null)
                if (enemyBullets.get(i).getEnemyBulletX() == 0) {
                    enemyBullets.remove(i);
                    int r = (int) (Math.random() * enemies.size());
                    if (enemies.get(r) != null)
                        enemyBullets.add(enemies.get(r).shoot());
                }
        }
        for (int j = 0; j < enemyBoss1Bullets.size(); j++) {
            if (enemyBoss1Bullets.get(j) != null && boss1 != null){
                if (enemyBoss1Bullets.get(j).getEnemyBoss1Bullet_x() <= 0 ){
                    enemyBoss1Bullets.remove(j);
                }
            }
        }
    }
    private void checkRepairBox() {
        if(live < 10) {
            for (int h = 0; h < repairBoxes.size(); h++) {
                if (repairBoxes.get(h) != null) {
                    if (player.getPlayerX() + SQUARE_SIZE >= repairBoxes.get(h).getRepairBoxX() && player.getPlayerY() <= repairBoxes.get(h).getRepairBoxY() + SQUARE_SIZE && player.getPlayerY() + SQUARE_SIZE >= repairBoxes.get(h).getRepairBoxY() && player.getPlayerX() <= repairBoxes.get(h).getRepairBoxX() + SQUARE_SIZE) {
                        for (int i = 0; i < 4; i++) {
                            live++;
                        }
                        money++;
                        repairBoxes.get(h).setRepairBox_x((int) (Math.random() * 420));
                        repairBoxes.get(h).setRepairBox_y((int) (Math.random() * 420));
                    }
                }
            }
        }
    }
    private void checkCrash(){
        for (int c = 0; c < enemies.size(); c++) {
            if (enemies.get(c) != null) {
                if (player.getPlayerX() + SQUARE_SIZE >= enemies.get(c).getEnemyX() && player.getPlayerY() <= enemies.get(c).getEnemyY() + SQUARE_SIZE && player.getPlayerY() + SQUARE_SIZE >= enemies.get(c).getEnemyY() && player.getPlayerX() <= enemies.get(c).getEnemyX() + SQUARE_SIZE) {
                    enemies.set(c,null);
                    live--;
                    killedEnemy++;
                    killedEnemyScore++;
                    money++;
                }
            }
        }
    }
    private void spawning() {
        if (killedEnemy / 2 == 1 && score <= 30) {
            killedEnemy = 0;
            Enemy en1 = new Enemy();
            enemies.add(en1);
            Enemy en2 = new Enemy();
            enemies.add(en2);
            Enemy en3 = new Enemy();
            enemies.add(en3);
            enemyBullets.add(en1.shoot());
            enemyBullets.add(en2.shoot());
            enemyBullets.add(en3.shoot());
        }
        if (score >= 30) {
            for (int j = 0; j < enemies.size(); j++) {
                for (int i = 0; i < enemyBullets.size(); i++) {
                    enemies.set(j, null);
                    enemyBullets.set(i, null);
                    spawnBoss1 = true;
                    if(bonusMoney1 == 0){
                        bonusMoney1++;
                        money += 20;
                    }
                }
            }
        }
    }
    private void boss1Fight() {
        if(spawnBoss1 && boss1 != null) {
            moveBoss1();
        }
        if(playerDefeatBoss1){
            boss1 = null;
        }
        if (boss1Live < 0) {
            playerDefeatBoss1 = true;
            if (defeatBoss1Cash == 0) {
                defeatBoss1Cash++;
                money += 50;
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        if(inGame) {
            if (pauze == false){
                checkCrash();
                moveBullets();
                enemyMove();
                boss1Fight();
                spawning();
                checkCollision();
                checkRepairBox();
            }
        }
        repaint();
    }
    public class TAdapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if ((key == KeyEvent.VK_P && !pauze)){pauze = true;} else { pauze = false;}
            if (!pauze){
                if ((key == KeyEvent.VK_RIGHT) && player.getPlayerX() <= 450 ) {
                    player.setPlayer_x(player.getPlayerX() + 10);
                }
                if ((key == KeyEvent.VK_LEFT) && player.getPlayerX() >= 10) {
                    player.setPlayer_x(player.getPlayerX() - 10);
                }
                if ((key == KeyEvent.VK_UP) && player.getPlayerY() >= 10) {
                    player.setPlayer_y(player.getPlayerY() - 10 );
                }
                if ((key == KeyEvent.VK_DOWN) && player.getPlayerY() <= 410) {
                    player.setPlayer_y(player.getPlayerY() + 10);
                }
                if ((key == KeyEvent.VK_SPACE)) {
                    bullets.add(player.shoot());
                }
                if((key == KeyEvent.VK_K)){
                    score = 31;
                }
            }
            if (startMenu == true){
                if (key == KeyEvent.VK_UP){
                    pozycjaStrzalek--;
                }
                if (key == KeyEvent.VK_DOWN){
                    pozycjaStrzalek++;
                }
            }
        }}}