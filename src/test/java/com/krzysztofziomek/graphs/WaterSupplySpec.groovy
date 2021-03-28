package com.krzysztofziomek.graphs

import spock.lang.Specification


class WaterSupplySpec extends Specification {

    /*
        Input:
        4
        1 2
        2 3
        3 4
        0 1 1 0
     */

    def 'test 4 cities with 2 blocked'() {
        given:
        def blocked = [2, 3] as Set
        def graph = [1: [2], 2: [1, 2], 3: [2, 4], 4: [3]]

        when:
        int result = WaterSupply.max(graph, blocked)

        then:
        result == 2
    }

    /*
    Input :
        7
        1 2
        2 3
        3 4
        4 5
        5 6
        6 7
        0 1 1 0 0 0 0
     */

    def 'test 7 cities with 2 blocked'() {
        given:
        def blocked = [2, 3] as Set
        def graph = [1: [2], 2: [1, 2], 3: [2, 4], 4: [3, 5], 5: [4, 6], 6: [5, 7], 7: [6]]

        when:
        int result = WaterSupply.max(graph, blocked)

        then:
        result == 5
    }
}
