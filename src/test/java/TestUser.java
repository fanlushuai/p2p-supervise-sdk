import com.open.sdk.bean.common.InfTypeEnum;
import com.open.sdk.bean.common.ReqMsg;
import com.open.sdk.bean.common.Rsp;
import com.open.sdk.bean.user.User;
import com.open.sdk.bean.user.UserBankAccount;
import com.open.sdk.util.Util;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;
import org.cert.open.CertException;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.open.sdk.util.Util.certToolV1;

@Slf4j
public class TestUser extends TestBase {

    @Test
    @Ignore
    public void testUser() throws IOException, CertException {
        String idCard = "411222198006091429";
        String phone = "13011111111";
        JSONObject jsonObject = certToolV1.phoneHash(phone);

        List<UserBankAccount> bankAccountList = new ArrayList<>();
        UserBankAccount userBankAccount = new UserBankAccount();
        userBankAccount.setUserBankAccount("6228480240389521611");
        bankAccountList.add(userBankAccount);

        User user = User.builder().userCreateTime(Util.getDateTimeStr())//yyyy-MM-dd HH:mm:ss
                .sourceCode(configStorage.getSourceCode())
                .userType("1")//1-自然人／2-企业
//        user.setUserStatus("2");//?已弃用
                .userAttr("1")//1-出借方／2-借款方／3- 出借方＋借款方/4-自代偿 平台方/5-第三方代偿/6- 受托支付方
                .userName("王*")
                .countries("1")//1-中国大陆；2-中国港澳台；3-国外 没有-1
                .cardType("1")//1-身份证；2-护照；4-台 湾居民来往大陆通行证；5- 港澳居民来往内地通行证； 6-外国人永久居留身份证； 7-三证合一证/五证合一 证
                .userIdcard(certToolV1.getIdcardAscription(idCard))//个人证件号必须脱敏 后 4 位；所有企业证件号不 可以脱敏

                .userIdcardHash(certToolV1.idCardHash(idCard))
                .userPhone(certToolV1.getPhoneAscription(phone))
                .userPhoneHash(jsonObject.getString("phone"))
                .userUuid(jsonObject.getString("salt"))
                .userLawperson("-1")//用户类型是 企业 必填， ， 用户类型是自然人填写 -1
                .userFund("-1")
                .userProvince("-1")
                .userAddress("-1")
                .registerDate("-1")
                .userMail("xxxfasdfsdsd@qq.com")
                .userSex("1")
                .version(configStorage.getVersion()).bankAccounts(bankAccountList).build();

        List<User> userList = new ArrayList<>();
        userList.add(user);

        ReqMsg<User> reqMsg = new ReqMsg<>();
        String batchNum = certToolV1.batchNumber(configStorage.getSourceCode(), Util.getDateStr(), "1", "1");
        String checkCode = certToolV1.checkCode(Util.toJson(reqMsg.getDataList()));
        reqMsg.setParam(configStorage, InfTypeEnum.USER, batchNum, checkCode, userList);

        Rsp rsp = uploadService.user(reqMsg.toJson()).execute().body();
    }

}
