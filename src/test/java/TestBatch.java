import com.open.sdk.bean.common.*;
import com.open.sdk.util.Util;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * 测试环境的batch不正常，有待线上环境验证
 */
public class TestBatch extends TestBase {

    @Test
    public void testBatchMessage() throws IOException {

        ReqMsgBatch reqMsg = new ReqMsgBatch();

        reqMsg.setInfTypeEnum(InfTypeEnum.USER);
        reqMsg.setBatchNum("CERT20190408024_201904171_1000");
        reqMsg.setDataTypeIfBatch(configStorage.getDataType());

        Long now = System.currentTimeMillis();
        String nonce = Util.genNonce();

        reqMsg.setApiKey(Util.certToolV1.getApiKey(configStorage.getApiKey(), configStorage.getSourceCode(), configStorage.getVersion(), now, nonce));
        reqMsg.setTimestamp(now + "");
        reqMsg.setNonce(nonce);
        reqMsg.setSourceCode(configStorage.getSourceCode());
        reqMsg.setVersion(configStorage.getVersion());

        Rsp<List<RspResultBatchMessage>> rsp = reconciliationService.batchMessage(Util.toMapStringString(reqMsg.toJson())).execute().body();

    }

    /**
     * 404
     */
    @Test
    public void testBatchNum() throws IOException {

        ReqMsgBatch reqMsg = new ReqMsgBatch();
        reqMsg.setSourceCode(configStorage.getSourceCode());
        reqMsg.setVersion(configStorage.getVersion());

        reqMsg.setInfTypeEnum(InfTypeEnum.USER);
        reqMsg.setSentDate("2019-04-08");
        reqMsg.setDataTypeIfBatch(configStorage.getDataType());

        Long now = System.currentTimeMillis();
        String nonce = Util.genNonce();
        reqMsg.setApiKey(Util.certToolV1.getApiKey(configStorage.getApiKey(), configStorage.getSourceCode(), configStorage.getVersion(), now, nonce));
        reqMsg.setTimestamp(now + "");
        reqMsg.setNonce(nonce);

        RspBatch<RspResultBatchNum> rsp = reconciliationService.batchNum(Util.toMapStringString(reqMsg.toJson())).execute().body();

    }

    /**
     * 异常
     */
    @Test
    public void testBatchList() throws IOException {

        ReqMsgBatch reqMsg = new ReqMsgBatch();
        Long now = System.currentTimeMillis();
        String nonce = Util.genNonce();

        reqMsg.setApiKey(Util.certToolV1.getApiKey(configStorage.getApiKey(), configStorage.getSourceCode(), configStorage.getVersion(), now, nonce));
        reqMsg.setDataTypeIfBatch(configStorage.getDataType());

        reqMsg.setPageNum("1");
        reqMsg.setTimestamp(now + "");
        reqMsg.setNonce(nonce);

        reqMsg.setSourceCode(configStorage.getSourceCode());
        reqMsg.setSentDate("2019-04-08");
        reqMsg.setVersion(configStorage.getVersion());
        reqMsg.setPutType("1");//1：所有推送的批次，2：入库成功的批次，3：入库失败的批次）
        reqMsg.setInfTypeEnum(InfTypeEnum.USER);

        Rsp<List<String>> rsp = reconciliationService.batchList(Util.toMapStringString(reqMsg.toJson())).execute().body();

    }


}
