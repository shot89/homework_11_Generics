sealed class FireType {
    object SingleShot : FireType()

    data class BurstShooting (
        var countShot: Int
    ) : FireType()
}

