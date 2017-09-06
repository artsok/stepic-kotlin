package collections

/*

Get used to new style

Rewrite the following Java function to Kotlin.

public Collection<String> doSomethingStrangeWithCollection(
        Collection<String> collection
) {
    Map<Integer, List<String>> groupsByLength = Maps.newHashMap();
    for (String s : collection) {
        List<String> strings = groupsByLength.get(s.length());
        if (strings == null) {
            strings = Lists.newArrayList();
            groupsByLength.put(s.length(), strings);
        }
        strings.add(s);
    }

    int maximumSizeO fGroup = 0;
    for (List<String> group : groupsByLength.values()) {
        if (group.size() > maximumSizeOfGroup) {
            maximumSizeOfGroup = group.size();
        }
    }

    for (List<String> group : groupsByLength.values()) {
        if (group.size() == maximumSizeOfGroup) {
            return group;
        }
    }
    return null;
}

//fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
//    val groupsByLength = collection. groupBy { s -> TODO() }
//    val maximumSizeOfGroup = groupsByLength.values.map { group -> TODO() }.max()
//    return groupsByLength.values.firstOrNull { group -> TODO() }
//}
 */

fun doSomethingStrangeWithCollection(collection:Collection<String>):Collection<String>? {
    val groupsByLength:Map<Int, List<String>> = collection.groupBy { it.length }
    val maximumSizeOfGroup:Int? = groupsByLength.values.maxBy { it.size }?.size
    return groupsByLength.values.maxBy { it.size == maximumSizeOfGroup }
}
