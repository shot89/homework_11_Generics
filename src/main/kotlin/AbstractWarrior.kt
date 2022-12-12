abstract class AbstractWarrior(
    var health: Int,
    var hitProbability: Int,
    var weapons: AbstractWeapon,
    var evasion: Int
) : Warrior {

    override var chanceOfHit = this.evasion


    private var currentHealth: Int = this.health

    override var isKilled = false

    override fun attack(enemy: Warrior) {
        for (bullet in weapons.getBullet()){
            if (!weapons.ammoClip.isEmpty() && hitProbability.probability() && !enemy.chanceOfHit.probability()) {
                var damage = bullet.currentDamage()
                enemy.getHit(damage)
                println("$this нанес урон $damage $enemy")
            }
            println("$this промахнулся по $enemy")
        }

    }

    override fun getHit(damage: Int) {
        currentHealth -= damage
        if (currentHealth <= 0) {
            isKilled = true
        }
    }

    override fun getCurrentHealth(): Int {
        return currentHealth
    }

    override fun toString(): String {
        return this::class.simpleName.toString()
    }
}