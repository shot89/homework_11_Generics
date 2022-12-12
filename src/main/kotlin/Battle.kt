
import kotlin.random.Random

class Battle() {

    var counterTerrorists: Team = Team(10, "Counter-Terrorists")
    var terrorists: Team = Team(10, "Terrorists")
    var whoStart: Boolean = Random.nextBoolean()

    var isGameOver: Boolean = false

    fun getStatusBattle() {
        if (counterTerrorists.team.isEmpty()) BattleState.TerroristsWin(counterTerrorists)
        else if (terrorists.team.isEmpty()) BattleState.CounterTerroristsWin(terrorists)
        else BattleState.NothingWin(counterTerrorists, terrorists)
    }

    fun fight(warrior: Warrior) {
        var enemy: Warrior
        var IsCounter = counterTerrorists.team.contains(warrior)
        if (IsCounter && !terrorists.team.isEmpty()) {
            enemy = terrorists.team[Random.nextInt(0, terrorists.team.size)]
        } else {
            if (!counterTerrorists.team.isEmpty()) {
                enemy = counterTerrorists.team[Random.nextInt(0, counterTerrorists.team.size)]
            } else {
                return
            }
        }

        warrior.attack(enemy)
        if (IsCounter && enemy.isKilled) terrorists.team.remove(enemy)
        else if (enemy.isKilled) counterTerrorists.team.remove(enemy)
    }

    fun battle(){
        if (whoStart){
            println("Ход Counter-Terrorists\n")
            battleIteration(counterTerrorists.team)
            println("Ход Terrorists\n")
            battleIteration(terrorists.team)
        } else{
            println("Ход Terrorists\n")
            battleIteration(terrorists.team)
            println("Ход Counter-Terrorists\n")
            battleIteration(counterTerrorists.team)
        }
        Thread.sleep(1000)
        println()
        getStatusBattle()
        if (counterTerrorists.team.isEmpty()||terrorists.team.isEmpty()) isGameOver = true
    }

    fun battleIteration(team: MutableList<Warrior>){
        for (warrior in team){
            fight(warrior)
        }
    }

}