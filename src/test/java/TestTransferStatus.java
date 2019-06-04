import com.open.sdk.bean.common.InfTypeEnum;
import com.open.sdk.bean.common.ReqMsg;
import com.open.sdk.bean.common.Rsp;
import com.open.sdk.bean.transferstatus.TransferStatus;
import com.open.sdk.util.Util;
import org.cert.open.CertException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.open.sdk.util.Util.certToolV1;

public class TestTransferStatus extends TestBase {

    @Test
//    @Ignore
    public void testTransferStatus() throws CertException, IOException {

        List list = new ArrayList<>();
        list.add(
                TransferStatus.builder()
                        .amount("0.00").interest("0.00").floatMoney("0.00").productDate(Util.getDateTimeStr())
                        .sourceCode(configStorage.getSourceCode()).transferId("1").transferStatus("1").version(configStorage.getVersion())
                        .build()
        );

        ReqMsg<TransferStatus> reqMsg = new ReqMsg<>();

        //todo 根据自己系统。自己实现。
        String batchNum = certToolV1.batchNumber(configStorage.getSourceCode(), Util.getDateStr(), "1", "1");
        String checkCode = certToolV1.checkCode(Util.toJson(reqMsg.getDataList()));

        reqMsg.setParam(configStorage, InfTypeEnum.TRANSFER_STATUS, batchNum, checkCode, list);

        Rsp rsp = uploadService.transferStatus(reqMsg.toJson()).execute().body();

    }
}
