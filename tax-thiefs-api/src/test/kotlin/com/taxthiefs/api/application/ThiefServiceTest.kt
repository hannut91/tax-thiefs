package com.taxthiefs.api.application

import com.taxthiefs.api.domain.Thief
import com.taxthiefs.api.domain.ThiefRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.MockitoAnnotations

internal class ThiefServiceTest {
    lateinit var thiefService: ThiefService

    @Mock
    lateinit var thiefRepository: ThiefRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        thiefService = ThiefService(thiefRepository)
    }

    @Test
    fun `getTheifs`() {
        val mockThiefs = arrayListOf(
                Thief(1, 2019, "홍영철", 46, "", "예술 스포츠 및 여가관련 서비스업 "
                        , "서울특별시 강서구 까치산로4길 75-37_화곡동", 163299, "부가가치세 등 2",
                        "2017-04-30", "2013년 부가가치세 등 총 9건 163,299 체납")
        )

        given(thiefRepository.findAll()).willReturn(mockThiefs)

        val thiefs = thiefService.getThiefs()

        assertThat(thiefs.first().name).isEqualTo("홍영철")
    }
}