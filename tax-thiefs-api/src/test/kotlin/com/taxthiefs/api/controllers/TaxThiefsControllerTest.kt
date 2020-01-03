package com.taxthiefs.api.controllers

import com.taxthiefs.api.application.ThiefService
import com.taxthiefs.api.domain.Thief
import org.hamcrest.CoreMatchers.containsString
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TaxThiefsController::class)
internal class TaxThiefsControllerTest {
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var thiefService: ThiefService

    @Test
    fun `Get theifs`() {
        val mockThiefs = arrayListOf(
                Thief(1, 2019, "홍영철", 46, "", "예술 스포츠 및 여가관련 서비스업 "
                        , "서울특별시 강서구 까치산로4길 75-37_화곡동", 163299, "부가가치세 등 2",
                        "2017-04-30", "2013년 부가가치세 등 총 9건 163,299 체납")
        )

        given(thiefService.getThiefs()).willReturn(mockThiefs)

        mockMvc.perform(get("/thiefs"))
                .andExpect(status().isOk)
                .andExpect(content().string(containsString("홍영철")))
                .andExpect(content().string(containsString("[")))
                .andExpect(content().string(containsString("address")))
    }
}