package edp.pageobject.pages.impl;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import edp.core.annotations.Page;
import edp.pageobject.pages.interfaces.IOpenShift;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.actions;

@Lazy
@Page
@Scope("prototype")
public class OpenShift implements IOpenShift {
    private static final String RESOURCES_BUTTON = "//span[text()='Resources']";
    private static final String SSO_BUTTON = "//a[contains(@href,'SSO')]";
    private static final String SECRETS_BUTTON = "//span[text()='Secrets']";
    private static final String ADD_TO_PROJECT_BUTTON = "//span[text()='Add to Project']";
    private static final String YAML_JSON_OPTION = "//ul[@class='dropdown-menu dropdown-menu-right']//a[text()='Import YAML / JSON']";
    private static final String IMPORT_YAML_FIELD = "//div[@class='ace_content']";
    private static final String IMPORT_YAML_FIELD_CLICK = "//div[@class='ace_content']";
    private static final String CREATE_SECRET_BUTTON = "//button[@id='nextButton']";
    private static final String CREATE_ANYWAY_BUTTON = "//button[text()='Create Anyway']";


    @Override
    public void clickResourcesButton() {
        $x(RESOURCES_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickSsoButton() {
        $x(SSO_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickSecretsButton() {
        $x(SECRETS_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void clickAddToProjectButton() {
        $x(ADD_TO_PROJECT_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void selectYamlJsonOption() {
        $x(YAML_JSON_OPTION).should(Condition.visible).click();
    }

    @Override
    public void enterGitlabSshKey(String sshKey) {
        SelenideElement element = $x(IMPORT_YAML_FIELD);
        element.click();
        element.sendKeys("kind: Secret\n" +
                "apiVersion: v1\n" +
                "metadata:\n" +
                "  name: gitlab-sshkey1\n" +
                "data:\n" +
                "  id_rsa: >-\n" +
                "    LS0tLS1CRUdJTiBPUEVOU1NIIFBSSVZBVEUgS0VZLS0tLS0KYjNCbGJuTnphQzFyWlhrdGRqRUFBQUFBQkc1dmJtVUFBQUFFYm05dVpRQUFBQUFBQUFBQkFBQUJsd0FBQUFkemMyZ3RjbgpOaEFBQUFBd0VBQVFBQUFZRUF0NGFyOWllVEFRcm02d05HbkMrd3E2UmxPakJGZXFnanZIQVhLYzlLV1lTaGpVeXdkYlZSCmsxM3BVcVR1bExEV2Z6TGFReXUxV215M0lHT0k3SjRucUtEek9ZYlJiYktxdTk0VTd0bFg5MGUzSEpaRWFsL2l5QmhSU2sKd2dTRnpOd3FlVjFmVFFpTXdFY1dIb2xZZ29DcFFLTHdQd0czcFRhRWhjV3Jhc3JqQ3VaTURXR2dCUUJsa3pHVnk4eTdncQp0bVBHUm0zWldETi9tV2FGL29jQzZEelBkeEV2K1JBWiswZ0FuTVNUbFBRUXBDemd2eGsyU0c4SUlGcGZyWVNxL2dDWXZsCkZOSVh1SEZrM0ZsQUhiUWlxQVBUSGZiTkJlcHR2eGhuV0dJSVdiSmhFUU9GdVFTMWJDa2t1WVROSGRqQnN3RHkvZzBzdloKT1VkekVyZitFelZMa2M5amxtTnkrNEJWSGxrMXVzeUhOVmRjOFFqaTNlNTNRQjlMbFhHUkZJOE5lN3dGZ2k0UkhEczhPcwoxNVdxM1lBRGMvU2VJSWhjRFhkWnhHS1JvZnJrTFJvcC9PdENJOUp4VDEwbDBSd3pjWkhMbE5UWHNDQ1JxMGNZNzBpMXRpCjhBSitiYkFMb1lYRFBRajREc0kyMnZSOUp1M0ZNV2FiT091eFBycWpBQUFGbUpTaGxReVVvWlVNQUFBQUIzTnphQzF5YzIKRUFBQUdCQUxlR3EvWW5rd0VLNXVzRFJwd3ZzS3VrWlRvd1JYcW9JN3h3RnluUFNsbUVvWTFNc0hXMVVaTmQ2VktrN3BTdwoxbjh5MmtNcnRWcHN0eUJqaU95ZUo2aWc4em1HMFcyeXFydmVGTzdaVi9kSHR4eVdSR3BmNHNnWVVVcE1JRWhjemNLbmxkClgwMElqTUJIRmg2SldJS0FxVUNpOEQ4QnQ2VTJoSVhGcTJySzR3cm1UQTFob0FVQVpaTXhsY3ZNdTRLclpqeGtadDJWZ3oKZjVsbWhmNkhBdWc4ejNjUkwva1FHZnRJQUp6RWs1VDBFS1FzNEw4Wk5raHZDQ0JhWDYyRXF2NEFtTDVSVFNGN2h4Wk54WgpRQjIwSXFnRDB4MzJ6UVhxYmI4WVoxaGlDRm15WVJFRGhia0V0V3dwSkxtRXpSM1l3Yk1BOHY0TkxMMlRsSGN4SzMvaE0xClM1SFBZNVpqY3Z1QVZSNVpOYnJNaHpWWFhQRUk0dDN1ZDBBZlM1VnhrUlNQRFh1OEJZSXVFUnc3UERyTmVWcXQyQUEzUDAKbmlDSVhBMTNXY1Jpa2FINjVDMGFLZnpyUWlQU2NVOWRKZEVjTTNHUnk1VFUxN0Fna2F0SEdPOUl0Yll2QUNmbTJ3QzZHRgp3ejBJK0E3Q050cjBmU2J0eFRGbW16anJzVDY2b3dBQUFBTUJBQUVBQUFHQkFMR0xaa2FmYUZhazNscFM4L2RiSjVZVlZ4CnlnNEVaVjdTUjZaOTQ1dkZxM3RiWkZqNXlBQ2VmLy9SM0hrMHRqZkU3WHVsRXJNcW5FN0xBM3VwbjJNcld1NXo0cXorWkkKNTJVUjVyeGVwUHdEZEFFQzJqTHlpaWs3WlVEMFBuTGkzT2ZJU21zUENNS2VaRm52OXhyWitxcXBKdVR1OFZVVDFTYllnZwpmOEd6ZjB2bkdZSUVoTkx4M0ZJMnNRelZCajNXWlBSZHlTbnFYMlJDWDZDZnovVGUrd0RLREtqdGRySFVkOEU2T1ZoSlNnClBJMG5JVkdlS1dhUGk1UUkrZkNhbTFBVThsdE9GWnZLSnZONDRET3lqVHZBQVl2UFJTUUpsdGtOWnE5bXZIeGQzeGFpMUgKYzVPTHQ4L1ZxZTV2blRmNHcvUE1vdXFXMnhYOVE1bUZGdDU5ZzQ4TkQrRXprbDhiNmQvTEdOSGdybUVzT0tsU1ZQR1RvNAp6aStGVGx4K200MjJtUFR5TG9USXo5U1BYQWZTZDJtODdJZ21GaGtHbTg1dHpZMVVHOXBQR0FGV2ZuSmZwNzFOV0wwRVQrCjJSc3JVMGlHYllCa05pRXNWbmVTdlYzTHdVTVNyV3owbnVidmF6RXdkN1EvSXV2blJXOXFidFQrUGUzR1VWdGxnK2tRQUEKQU1Bb2YvRFdENUxzak5WRkhrMlY1T1d6NW5xa0pLUGFRK2pCWWxPTzAwK0hkWEVyV0RicFFHT2MyY3FUYzl2T2JMWmZtRApzS2trK2t6RmJkOG0zMkNxaFdVM29zMjNDZklSaTBiRGR3NWw1WHlTbGhkejkvM0VTUXlJMnpBNXRsMmY0c3c4UlcwbGlVCmZjRGlPcUR5TkluVXJmM1JVNW1SRit4NE5GQkR5UVJsS0xXaVM3Z3Z3STQyZ1VpREN5WFVpV1ppdGRyNHdld2NQOUc0aW8Ka21IcHhGeDF3MkR6cTErRVFXVEJGSUI1b1cwQVd1bjhnQ2xZeVl0M0lRR3dTaU5hNEFBQURCQU81RHQxa2Z3RG9wTmNTaApDaGY5T2NEQmNNWFVneWRPUTJHYVVEMU9CNlh2ektLWGpmZkQwaFJ2Q0QrN21XeTBsdTJXbnozSFZ0ZGQ1b1kxdm9qVUo0CllkUHFFaFl5a0M5bmxBa05Gck1zS0wxbUtRQnlHdkE3RGJISStTYlJ1eU5wWTYyaE01WmEwcXpYNUc5a2Z4TmlweGxKY08KVkZlWXNScGxuRjVkci9VUk10QkRBNk9QSnFacEJDb095QmF4OFpsRnVYNUFWd0FidlB2Y1dlaDBpUlFuaVU3dDhnNW1iego5elVKeUFZTWZrZldLQXNjY1Voazc1aUdLSXFXODBxd0FBQU1FQXhTL2hCdDUxQVNIUURnR1BRWmFVeHZUU3hWd0NDckxxCmNtOG9QTlJJb1dVZC90VmlZTFhwNEZQM0tsK1JabUNJSmtrUGhLWHJSWE41UXJBSmRSTUR1SzNCYXVab28wQ2g5Z2lwYkQKeEpLN09tNjVMRndoY0lOUEh6dG1sQmxvZHE4MEV4TmFFbDdtbkU0SmZYZm9GaUNFT1NGVE1WZSs2VG4yZXpHUE1sMzgrUQpLV3RMcTBuZkd1THBvdUJPOU4yREdpdVhpNEppeWJmMmxtTGJaSENleTFXUmwwS3M4Q1B3VHR3dld2RG4wUnYxM3hwNGIwCkRBU1hCdm5TN2FPV0hwQUFBQUcwUnRlWFJ5YjE5TGIyNXZibTkyUUVWUVZVRkxTRUZYTURFd01nRUNBd1FGQmdjPQotLS0tLUVORCBPUEVOU1NIIFBSSVZBVEUgS0VZLS0tLS0K\n" +
                "  id_rsa.pub: >-\n" +
                "    c3NoLXJzYSBBQUFBQjNOemFDMXljMkVBQUFBREFRQUJBQUFCZ1FDM2hxdjJKNU1CQ3VickEwYWNMN0NycEdVNk1FVjZxQ084Y0JjcHowcFpoS0dOVExCMXRWR1RYZWxTcE82VXNOWi9NdHBESzdWYWJMY2dZNGpzbmllb29QTTVodEZ0c3FxNzNoVHUyVmYzUjdjY2xrUnFYK0xJR0ZGS1RDQklYTTNDcDVYVjlOQ0l6QVJ4WWVpVmlDZ0tsQW92QS9BYmVsTm9TRnhhdHF5dU1LNWt3TllhQUZBR1dUTVpYTHpMdUNxMlk4WkdiZGxZTTMrWlpvWCtod0xvUE05M0VTLzVFQm43U0FDY3hKT1U5QkNrTE9DL0dUWklid2dnV2wrdGhLcitBSmkrVVUwaGU0Y1dUY1dVQWR0Q0tvQTlNZDlzMEY2bTIvR0dkWVlnaFpzbUVSQTRXNUJMVnNLU1M1aE0wZDJNR3pBUEwrRFN5OWs1UjNNU3QvNFROVXVSejJPV1kzTDdnRlVlV1RXNnpJYzFWMXp4Q09MZDduZEFIMHVWY1pFVWp3MTd2QVdDTGhFY096dzZ6WGxhcmRnQU56OUo0Z2lGd05kMW5FWXBHaCt1UXRHaW44NjBJajBuRlBYU1hSSEROeGtjdVUxTmV3SUpHclJ4anZTTFcyTHdBbjV0c0F1aGhjTTlDUGdPd2piYTlIMG03Y1V4WnBzNDY3RSt1cU09IERteXRyb19Lb25vbm92QEVQVUFLSEFXMDEwMgo=\n" +
                "  username: ZG15dHJvX2tvbm9ub3ZAZXBhbS5jb20=\n" +
                "type: Opaque\n");

//       actions().moveToElement(element).sendKeys(sshKey);
//        $x(IMPORT_YAML_FIELD).shouldBe(Condition.visible).setValue(sshKey);
    }

    @Override
    public void clickCreateSecretButton() {
        $x(CREATE_SECRET_BUTTON).shouldBe(Condition.visible).click();
    }

    @Override
    public void enterGitlabGitServer(String gitlabGitServer) {
        SelenideElement element = $x(IMPORT_YAML_FIELD);
        actions().moveToElement(element).click(element).sendKeys("apiVersion: v2.edp.epam.com/v1alpha1\n" +
                "kind: GitServer\n" +
                "metadata:\n" +
                "  name: git-epam\n" +
                "spec:\n" +
                "  createCodeReviewPipeline: false\n" +
                "gitHost: git.epam.com\n" +
                "gitUser: git\n" +
                "httpsPort: 443\n" +
                "nameSshKeySecret: gitlab-sshkey\n" +
                "sshPort: 22").perform();
    }

    @Override
    public void clickCreateAnywayButton() {
        $x(CREATE_ANYWAY_BUTTON).shouldBe(Condition.visible).click();
    }
}
