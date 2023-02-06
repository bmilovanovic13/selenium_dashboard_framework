package org_nebra_assertj

import org.assertj.core.api.Assertions
import org.assertj.core.data.Offset
import org.assertj.core.data.Percentage
import org.testng.annotations.Ignore
import org.testng.annotations.Test
import java.util.*

class AssertJDemo {

    @Ignore
    @Test
    fun stringTest() {
        val temp = "Hello World"
        Assertions.assertThat(temp).`as`("Ovde ide greska koju hoces").isNotNull
            .isNotEmpty
            .isNotBlank
            .isEqualTo("Hello World")
            .contains("Hello")
            .doesNotContain("Hi")
            .containsWhitespaces()
            .containsIgnoringCase("world")
            .matches("\\w.*" + "World")
            .doesNotContainPattern("\\d.*")
            .hasSize(11)
            .hasSizeGreaterThan(10)
            .hasSizeLessThan(20)
            .hasSizeBetween(10, 20)
            .endsWith("World")
            .isInstanceOf(String::class.java)
    }

    @Ignore
    @Test
    fun numbersTest() {
        val a = 10
        Assertions.assertThat(a)
            .isEqualTo(10)
            .isCloseTo(14, Offset.offset(5))
            .isInstanceOf(Int::class.java)
            .isBetween(3, 15)
            .isCloseTo(12, Percentage.withPercentage(30.0)) // procenat je procenat vrednosti a, u ovom slucaju oko 3
            .isNotCloseTo(15, Percentage.withPercentage(30.0))
            .isPositive
            .isEven
            .isGreaterThanOrEqualTo(5)
            .isLessThanOrEqualTo(20)
    }

    @Ignore
    @Test
    fun listTest() {
        val list = listOf("Testing", "Mini", "Bytes")
        val list2 = listOf("Testing", "Mini")
        val list3 = listOf("Automation", "selenium")
        Assertions.assertThat(list)
            .hasSize(3)
            .hasSizeBetween(2, 15)
            .hasAtLeastOneElementOfType(String::class.java)
            .isNotEmpty
            .contains("Testing")
            .doesNotContain("Automation")
            .startsWith("Testing")
            .containsExactlyInAnyOrder("Mini", "Testing", "Bytes")
            .containsExactly("Testing", "Mini", "Bytes")
            .withFailMessage("String is not having size less than 3").allMatch { s: String -> s.length > 3 }
            .containsAll(list2)
            .doesNotContainAnyElementsOf(list3)
    }

    @Ignore
    @Test
    fun mapTest() {
        val map: MutableMap<String, String> = HashMap()
        map["name"] = "Branko"
        map["channel"] = "Testing mini bytes"
        map["game"] = "cricket"
        Assertions.assertThat(map)
            .containsEntry("name", "Branko")
            .hasSize(3)
            .isNotEmpty
            .doesNotContainEntry("fav", "football")
            .doesNotContainKey("Game")
            .containsKey("channel")
            .containsValue("cricket")
    }

    @Ignore
    @Test
    fun customClassTest() {
        // nista bitno, ako zatreba vidi klip
    }
}