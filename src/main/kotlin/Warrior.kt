interface Warrior {
    var isKilled: Boolean
    var chanceOfHit: Int

    fun attack (enemy: Warrior)
    fun getHit (damage: Int)

    fun getCurrentHealth() : Int

}