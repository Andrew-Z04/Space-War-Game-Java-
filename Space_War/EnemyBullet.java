public class EnemyBullet {
    private int enemyBullet_x ;
    private int enemyBullet_y ;

    public EnemyBullet(Enemy e){
        enemyBullet_x = e.getEnemyX()+5;
        enemyBullet_y = e.getEnemyY()+10;
    }
    public int getEnemyBulletX() {
        return enemyBullet_x;
    }
    public int getEnemyBulletY() {
        return enemyBullet_y;
    }
    public void setEnemyBullet_x(int enemyBullet_x) {
        this.enemyBullet_x = enemyBullet_x;
    }
    public void setEnemyBullet_y(int enemybullet_y) {
        this.enemyBullet_y = enemybullet_y;
    }
    public void move() {
        this.enemyBullet_x -= 3;
    }
}
