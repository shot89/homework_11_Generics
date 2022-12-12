import kotlin.random.Random

fun main(args: Array<String>) {

    var battle = Battle()
    while (!battle.isGameOver){
        battle.battle()
    }

}

fun Int.probability(): Boolean {
    return Random.nextInt(1, 100) <= this
}

object Weapons {
    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon(8, FireType.SingleShot, "Pistol") {
            init {
                recharge()
            }
            override fun createBullet(): Ammo {
                return Ammo.STANDARD
            }
        }
    }
    fun createRifle(): AbstractWeapon {

        return object : AbstractWeapon(30, FireType.BurstShooting(5), "Rifle") {
            init {
                recharge()
            }
            override fun createBullet(): Ammo {
                return Ammo.STANDARD
            }
        }
    }
    fun createShotgun(): AbstractWeapon {
        return object : AbstractWeapon(6, FireType.BurstShooting(2), "Shotgun") {
            init {
                recharge()
            }
            override fun createBullet(): Ammo {
                return Ammo.STANDARD
            }
        }
    }
    fun createMortar(): AbstractWeapon {
        return object : AbstractWeapon(1, FireType.SingleShot, "Mortar") {
            init {
                recharge()
            }
            override fun createBullet(): Ammo {
                return Ammo.BREAKING
            }
        }
    }
}




