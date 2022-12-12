import kotlin.random.Random

open class Team {

    var name: String
    var numberWarriors: Int
    constructor(numberWarriors: Int, name: String) {
        this.numberWarriors = numberWarriors
        this.name = name
        createTeam()
    }

    var team = mutableListOf<Warrior>()


    fun createTeam () {
        for (j in 1..numberWarriors) {
            var temp = Random.nextInt(1, 100)
            if (temp < 10) {
                team.add(General())
            } else if (temp < 40) {
                team.add(Captain())
            } else {
                team.add(Soldier())
            }
        }
    }
}