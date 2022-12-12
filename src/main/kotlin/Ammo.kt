import kotlin.random.Random
import kotlin.random.nextInt

enum class Ammo(var damage: Int, var chanceOfKrit: Int, var coefficient: Int) {
    STANDARD(10, 75, 3),
    ARMORPIECING(5, 50, 5),
    BREAKING(50, 25, 10);

    fun currentDamage(): Int {

        if (chanceOfKrit.probability()) {
            return damage * coefficient
        } else {
            return damage
        }
    }
}

