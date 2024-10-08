package org.example.chap03;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달_뒤가_만료일이_됨() {
        PayData payData1 = PayData.builder()
                .billingDate(LocalDate.of(2024, 8, 1))
                .payAmount(10_000)
                .build();
        LocalDate expectedExpiryDate1 = LocalDate.of(2024, 9, 1);

        PayData payData2 = PayData.builder()
                .billingDate(LocalDate.of(2024, 5, 5))
                .payAmount(10_000)
                .build();
        LocalDate expectedExpiryDate2 = LocalDate.of(2024, 6, 5);

        this.assertExpiryDate(payData1, expectedExpiryDate1);
        this.assertExpiryDate(payData2, expectedExpiryDate2);
    }

    @Test
    void 만원_납부하면_납부일과_한달_뒤_일자가_같지_않음() {
        PayData payData1 = PayData.builder()
                .billingDate(LocalDate.of(2019, 1, 31))
                .payAmount(10_000)
                .build();
        LocalDate expectedExpiryDate1 = LocalDate.of(2019, 2, 28);

        PayData payData2 = PayData.builder()
                .billingDate(LocalDate.of(2019, 5, 31))
                .payAmount(10_000)
                .build();
        LocalDate expectedExpiryDate2 = LocalDate.of(2019, 6, 30);

        PayData payData3 = PayData.builder()
                .billingDate(LocalDate.of(2020, 1, 31))
                .payAmount(10_000)
                .build();
        LocalDate expectedExpiryDate3 = LocalDate.of(2020, 2, 29);

        this.assertExpiryDate(payData1, expectedExpiryDate1);
        this.assertExpiryDate(payData2, expectedExpiryDate2);
        this.assertExpiryDate(payData3, expectedExpiryDate3);
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_만원_납부() {
        PayData payData = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,31))
                .billingDate(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();

        this.assertExpiryDate(payData, LocalDate.of(2019, 3, 31));


        PayData payData2 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,1,30))
                .billingDate(LocalDate.of(2019,2,28))
                .payAmount(10_000)
                .build();

        this.assertExpiryDate(payData2, LocalDate.of(2019, 3, 30));

        PayData payData3 = PayData.builder()
                .firstBillingDate(LocalDate.of(2019,5,31))
                .billingDate(LocalDate.of(2019,6,30))
                .payAmount(10_000)
                .build();

        this.assertExpiryDate(payData3, LocalDate.of(2019, 7, 31));
    }

    @Test
    void 이만원_이상_납부하면_비례해서_만료일_계산() {
        this.assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(20_000)
                        .build(),
                LocalDate.of(2019, 5, 1));

        this.assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 3, 1))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2019, 6, 1));
    }

    @Test
    void 첫_납부일과_만료일_일자가_다를때_이만원_이상_납부() {
        assertExpiryDate(
                PayData.builder()
                    .firstBillingDate(LocalDate.of(2019, 1, 31))
                    .billingDate(LocalDate.of(2019, 2, 28))
                    .payAmount(20_000)
                    .build(),
                LocalDate.of(2019, 4, 30));

        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 1, 31))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(40_000)
                        .build(),
                LocalDate.of(2019, 6, 30));

        assertExpiryDate(
                PayData.builder()
                        .firstBillingDate(LocalDate.of(2019, 3, 31))
                        .billingDate(LocalDate.of(2019, 4, 30))
                        .payAmount(30_000)
                        .build(),
                LocalDate.of(2019, 7, 31));
    }

    @Test
    void 십만원을_납부하면_1년_제공() {
        this.assertExpiryDate(
                PayData.builder()
                    .billingDate(LocalDate.of(2019, 1, 28))
                    .payAmount(100_000)
                    .build(),
                LocalDate.of(2020, 1, 28)
        );

        this.assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2020, 2, 29))
                        .payAmount(100_000)
                        .build(),
                LocalDate.of(2021, 2, 28)
        );
    }

    @Test
    void 십만원초과해서_납부하면_금액에따라_정확한_만료기간_제공() {
        this.assertExpiryDate(
                PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(130_000)
                        .build(),
                LocalDate.of(2020, 4, 30)
        );
    }

    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate realExpiryDate = cal.calculateExpiryDate(payData);
        assertEquals(expectedExpiryDate, realExpiryDate);
    }
}
