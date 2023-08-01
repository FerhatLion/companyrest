package com.companyrest.tests;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersIntro {

    @Test
    public void test1(){
        assertThat(5+5, is(10));
        assertThat(5+5, equalTo(10));
        assertThat(5+5, is(equalTo(10)));

        assertThat(5+5, not(9));
        assertThat(5+5,is(not(9)));
        assertThat(5+5, is(not(equalTo(9))) );

        //number comparison
        assertThat(5+5, is(greaterThan(9)));


    }
}
