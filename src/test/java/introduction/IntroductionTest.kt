package introduction

import org.junit.Test
import kotlin.test.assertTrue

/**
 * Created by sokovets-av
 */
class IntroductionTest {

    @Test
    fun checkSimpleFunction() {
        assertTrue(start().equals("Stepic-OK"), "Ошибочка")
    }



}