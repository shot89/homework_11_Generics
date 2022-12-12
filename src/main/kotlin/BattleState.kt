sealed class BattleState(var team: Team) {
    class progress(team: Team) : BattleState(team) {
        var livedWariors = team.team.size
        var teamHealthSummary = 0
        fun printProgress() {
            println("Оставшихся в живых в команде ${team.name} - $livedWariors")
            getTeamSummaryHealth()
            println("Общее здоровье команды ${team.name} - $teamHealthSummary")
            getCommandContains()
        }

        fun getTeamSummaryHealth() {
            team.team.forEach { teamHealthSummary += it.getCurrentHealth() }
        }

        fun getCommandContains() {
            var warriors = team.team
            var soldierCount = 0
            var captainCount = 0
            var generalCount = 0
            for (i in warriors) {
                if (i is Soldier) soldierCount++
                if (i is Captain) captainCount++
                if (i is General) generalCount++
            }
            println(
                "Солдат - $soldierCount\n" +
                        "Капитанов - $captainCount\n" +
                        "Генералов - $generalCount"
            )

        }
    }

    class CounterTerroristsWin(team: Team) : BattleState(team) {
        init {
            printWin()
        }
        fun printWin() {
            if (team.team.isEmpty()) {
                println("Counter-terrorists win")
                BattleState.progress(team).printProgress()
            }
        }
    }

    class TerroristsWin(team: Team) : BattleState(team) {
        init {
            printWin()
        }
        fun printWin() {
            if (team.team.isEmpty()) {
                println("Terrorists win")
                BattleState.progress(team).printProgress()
            }
        }
    }

    class NothingWin(team1: Team, var team2: Team) : BattleState(team1) {

        init {
            printNothingWin()
        }

        fun printNothingWin() {
            if (!team.team.isEmpty() && !team2.team.isEmpty()) {
                println("Никто не выиграл команды в бою")
                println("===================")
                progress(team).printProgress()
                println("===================")
                progress(team2).printProgress()
            }

        }
    }
}
