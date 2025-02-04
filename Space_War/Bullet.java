public class Bullet {
    private int bullet_x ;
    private int bullet_y ;
    public Bullet(Player p) {
        bullet_x = p.getPlayerX() + 40;
        bullet_y = p.getPlayerY() + 38 / 2;
    }
    public int getBulletX() {
        return bullet_x;
    }
    public int getBulletY() {
        return bullet_y;
    }
    public void setBullet_x(int bullet_x) {
        this.bullet_x = bullet_x;
    }
    public void setBullet_y(int bullet_y) {
        this.bullet_y = bullet_y;
    }
    public void move() {
        this.bullet_x += 2;
    }
}
