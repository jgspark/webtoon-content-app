package com.lezhin.coding.web;

import com.lezhin.coding.constants.EvaluationType;
import com.lezhin.coding.mock.ContentsMock;
import com.lezhin.coding.mock.HistoryMock;
import com.lezhin.coding.mock.UserMock;
import com.lezhin.coding.service.HistoryService;
import com.lezhin.coding.service.dto.HistoryInfo;
import com.lezhin.coding.service.dto.PageDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.filter.CharacterEncodingFilter;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HistoryController.class)
class HistoryControllerTest {

  private MockMvc mockMvc;

  @MockBean private HistoryService historyService;

  @BeforeEach
  void init() {
    this.mockMvc =
        MockMvcBuilders.standaloneSetup(new HistoryController(historyService))
            .addFilter(new CharacterEncodingFilter("UTF-8", true))
            .build();
  }

  @Test
  @DisplayName("작품별 조회 API")
  void getHistories() throws Exception {

    Page<HistoryInfo> mocks =
        HistoryMock.createdPageList(UserMock.createdMock(), ContentsMock.createdMock());

    BDDMockito.given(historyService.getHistories(any())).willReturn(mocks);

    PageDTO pageDTO = new PageDTO(0, 10);

    ResultActions action =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/histories")
                    .param("page", pageDTO.getPage().toString())
                    .param("size", pageDTO.getSize().toString())
                    .contentType(MediaType.APPLICATION_JSON)
                    .characterEncoding("UTF-8"))
            .andDo(print());

    BDDMockito.then(historyService).should().getHistories(any());

    action
        .andExpect(status().isOk())
        .andExpect(jsonPath("$['content'][0]['id']").value(mocks.getContent().get(0).getId()))
        .andExpect(
            jsonPath("$['content'][0]['userName']").value(mocks.getContent().get(0).getUserName()))
        .andExpect(
            jsonPath("$['content'][0]['contentsName']")
                .value(mocks.getContent().get(0).getContentsName()))
        .andExpect(
            jsonPath("$['content'][0]['contentsType']")
                .value(mocks.getContent().get(0).getContentsType().name()))
        .andExpect(
            jsonPath("$['content'][0]['createdDate']")
                .value(mocks.getContent().get(0).getCreatedDate()));
  }
}
