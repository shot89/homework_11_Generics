class Stack<T> {

    val stack = arrayListOf<T>()

    fun push(item: T) {
        stack.add(item)
    }

    fun pop(): T {
        return stack.removeLast()
    }

    fun isEmpty(): Boolean {
        return stack.size == 0
    }
}
