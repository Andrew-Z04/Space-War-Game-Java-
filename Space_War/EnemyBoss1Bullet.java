public class EnemyBoss1Bullet {
    private int enemyBoss1Bullet_x ;
    private int enemyBoss1Bullet_y ;
    private int enemyBoss1BulletWidth = 16;
    private int enemyBoss1BulletHeight = 14;
    public EnemyBoss1Bullet(Boss1 b1){
            enemyBoss1Bullet_x = b1.getBoss1_x() + 5;
            enemyBoss1Bullet_y = b1.getBoss1_y() + 33;
    }
    public int getEnemyBoss1Bullet_x() {
        return enemyBoss1Bullet_x;
    }
    public void setEnemyBoss1Bullet_x(int enemyBoss1Bullet_x) {
        this.enemyBoss1Bullet_x = enemyBoss1Bullet_x;
    }
    public int getEnemyBoss1Bullet_y() {
        return enemyBoss1Bullet_y;
    }
    public void setEnemyBoss1Bullet_y(int enemyBoss1Bullet_y) {
        this.enemyBoss1Bullet_y = enemyBoss1Bullet_y;
    }
    public int getEnemyBoss1BulletWidth() {
        return enemyBoss1BulletWidth;
    }
    public void setEnemyBoss1BulletWidth(int enemyBoss1BulletWidth) {
        this.enemyBoss1BulletWidth = enemyBoss1BulletWidth;
    }
    public int getEnemyBoss1BulletHeight() {
        return enemyBoss1BulletHeight;
    }
    public void setEnemyBoss1BulletHeight(int enemyBoss1BulletHeight) {
        this.enemyBoss1BulletHeight = enemyBoss1BulletHeight;
    }
    public void move() {
        this.enemyBoss1Bullet_x -= 2;
    }
}
