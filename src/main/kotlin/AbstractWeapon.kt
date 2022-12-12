open class AbstractWeapon(
    var maxBullet: Int,
    var fireType: FireType,
    var typeWeapon: String
) {
    var ammoClip: Stack<Ammo> = Stack()

    open fun createBullet(): Ammo {
        return Ammo.STANDARD
    }

    open fun recharge() {
        if (ammoClip.isEmpty()) {
            for (j in 1..maxBullet) {
                ammoClip.push(createBullet())
            }
        }
    }

    fun getBullet(): MutableList<Ammo> {
        var tmp: MutableList<Ammo> = mutableListOf()
        if (!ammoClip.isEmpty()) {
            if (fireType is FireType.BurstShooting) {
                for (i in 0..(fireType as FireType.BurstShooting).countShot -1) {
                    if (!ammoClip.isEmpty()) tmp.add(ammoClip.pop())
                    else{
                        recharge()
                        break
                    }
                }
                return tmp
            } else {
                tmp.add(ammoClip.pop())
                return tmp
            }
        } else {
            recharge()
            return getBullet()
        }
    }

}