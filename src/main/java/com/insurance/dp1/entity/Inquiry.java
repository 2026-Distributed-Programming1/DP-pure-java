package com.insurance.dp1.entity;

import com.insurance.dp1.entity.enums.FaqCategory;
import com.insurance.dp1.entity.enums.InquiryStatus;
import com.insurance.dp1.entity.enums.InquiryType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Inquiry {

    @Id
    private String inquiryNo;

    @Enumerated(EnumType.STRING)
    private InquiryType inquiryType;

    @Column(length = 50)
    private String title;

    @Column(length = 1000)
    private String content;

    private Integer currentLength;
    private String attachmentFileName;
    private Long attachmentFileSize;
    private LocalDateTime receivedAt;

    @Enumerated(EnumType.STRING)
    private InquiryStatus status;

    private String answerContent;
    private LocalDateTime answeredAt;

    @Enumerated(EnumType.STRING)
    private FaqCategory faqCategory;

    private String faqQuestion;
    private String faqAnswer;
}
