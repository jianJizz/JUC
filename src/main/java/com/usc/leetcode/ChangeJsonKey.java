package com.usc.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author jianjianDuan
 * @date 2021/8/3 4:11 下午
 */
public class ChangeJsonKey {
    public static void main(String[] args) {
        String json = "{\"check_id\":\"3895514\",\"submit_user_id\":\"10316\",\"patient_id\":\"4102625\",\"org_id\":\"40166\",\"ukey\":\"d81e85d93628d289cc922f43e3677ca6\",\"report_status\":\"1\",\"image_quality\":\"0\",\"third_id\":\"bd96b2f629fe4f96ba205c5db86c8129\",\"review_status\":\"2\",\"review_type\":\"0\",\"last_review_time\":\"0000-00-00 00:00:00\",\"senior_time\":\"0000-00-00 00:00:00\",\"sync_status\":\"21\",\"same_patient\":\"1\",\"same_image\":\"0\",\"deleted\":\"0\",\"review_time\":\"2021-04-17 05:03:23\",\"package_type\":\"1\",\"upgrade_package\":\"0\",\"updated\":\"2021-04-17 05:04:34\",\"created\":\"2021-04-17 05:03:20\",\"check_user_id\":\"0\",\"check_time\":\"0000-00-00 00:00:00\",\"senior_user_id\":\"0\",\"recommend\":\"0\",\"patient_info_status\":\"3\",\"start_time\":\"2021-04-17 05:03:20\",\"md5_pdf\":\"\",\"print_status\":\"0\",\"print_time\":\"0000-00-00 00:00:00\",\"type\":\"0\",\"h5_status\":\"1\",\"h5_time\":\"2021-04-17 05:04:34\",\"h5_entry_type\":\"0\",\"ext_json\":{\"sn\":\"FD08DWCNW220390000R0\",\"seq\":1,\"city\":\"大连市\",\"camera\":\"fd16\",\"sub_type\":\"chronic\",\"reid_status\":\"1\",\"report_type\":\"zhongyou\",\"sales_status\":\"2\",\"did_consistency\":\"3\",\"double_bad_risky\":\"0\",\"suggestion_level\":\"2\"},\"is_chronic\":1,\"sn\":\"FD08DWCNW220390000R0\",\"has_signature\":0,\"submit_user_name\":\"辽宁平台_高济药店66\",\"equip_uuid\":\"\",\"equipment_type\":\"\",\"equipment_remark\":\"\",\"left_vision\":\"\",\"right_vision\":\"\",\"left_corrected_vision\":\"\",\"right_corrected_vision\":\"\",\"complained\":\"\",\"medical_history\":\"1,18\",\"other_history\":\"\",\"diabetes_time\":\"0\",\"sugar_state\":\"0\",\"medician_history\":\"\",\"algo_status\":\"10\",\"prob_341_od\":260,\"prob_341_os\":600,\"vcdr_od\":\"474\",\"vcdr_os\":\"570\",\"algo_time\":\"2021-04-17 05:03:23\",\"right_iop\":\"\",\"left_iop\":\"\",\"ikang_info_time\":\"0000-00-00 00:00:00\",\"upgrade_print_status\":\"-1\",\"upgrade_time\":\"0000-00-00 00:00:00\",\"next_suggestion\":\"\",\"middle_images\":[],\"suggestion_level\":\"5\",\"retina_age\":\"48\",\"left_bad_img_reason\":\"0\",\"right_bad_img_reason\":\"0\",\"extra\":{\"prob_166\":{\"od\":220,\"os\":277},\"recheck_time\":\"2021.05.17\",\"recheck_time_v2\":\"2021.05.17\",\"retina_age_ai\":\"48\",\"summary_risky_snapshot\":83,\"risk_wording_snapshot\":{\"presure\":\"11\",\"dr\":\"14\",\"heart\":\"13\",\"brain\":\"12\",\"anemia\":\"16\"}},\"detection_detail\":\"\",\"systolic_pressure\":\"0\",\"icvd\":\"0\",\"retina_ex\":{\"final_S0\":\"81.836889981865\",\"final_dr\":\"83.984\",\"final_Smax\":\"91\",\"final_Smin\":\"75\",\"overall_db\":\"0.015966701321304\",\"overall_hb\":\"150.37173461914\",\"overall_ht\":\"0.08772333431989\",\"overall_rc\":\"4.9511470794678\",\"final_blind\":\"3.2\",\"final_brain\":\"40.58793775\",\"final_heart\":\"32.976875\",\"overall_age\":\"40.310422897339\",\"overall_aux\":\"Array\",\"overall_dbp\":\"77.079650878906\",\"overall_hct\":\"43.671855926514\",\"overall_sbp\":\"125.50496292114\",\"risk_status\":\"1\",\"smoke_score\":\"25.9\",\"blood_status\":\"1\",\"final_anemia\":\"17.991193152145\",\"overall_icvd\":\"4.2715939612655\",\"smoke_status\":\"1\",\"final_presure\":\"63.815\",\"overall_gender\":\"0.23017216660082\",\"sparcspot_13_1\":\"17837\",\"sparcspot_13_2\":\"20386\",\"sparcspot_14_1\":\"0.10495\",\"sparcspot_14_2\":\"0.2358\",\"sparcspot_15_1\":\"2\",\"sparcspot_15_2\":\"2\",\"fd16_seg_status\":\"1\",\"overall_db_risk\":\"29.84\",\"overall_ht_risk\":\"62.4\",\"sparcspot_status\":\"1\",\"overall_male_risk\":\"2.1488624334353\",\"overall_female_risk\":\"1.9881802024028\",\"overall_ori_db_risk\":\"29.84\",\"overall_ori_ht_risk\":\"62.4\",\"arteriovenous_status\":3,\"overall_dementia_risk\":\"0.0057158151277036\",\"overall_dementia_score\":\"3.5411269664764\",\"smoke_questionnaire_status\":\"1\"},\"serious_f\":\"0\",\"configuration\":{\"btn_print_img\":\"3\",\"usable_diseases\":\"\"},\"usable_diseases\":[],\"risk_conf\":{\"switch\":\"all\",\"sort\":\"default\",\"presure_0\":\"11\",\"custom_sort\":[\"presure\",\"dr\",\"heart\",\"brain\",\"anemia\"],\"dr_0\":\"14\",\"heart_0\":\"13\",\"brain_0\":\"12\",\"anemia_level1_0\":\"16\",\"anemia_level2_1\":\"17\",\"anemia_level3_2\":\"18\",\"anemia_level4_3\":\"19\"},\"config_diseases\":1,\"dmyh_left\":0,\"dmyh_right\":0,\"images\":[{\"img_id\":\"7720850\",\"type\":\"2\",\"w\":800,\"h\":658,\"md5bin\":\"837b2c9f545a0574ffc311c5fa157679\",\"score\":\"0\",\"report_url\":\"\",\"brighten\":\"\",\"watermark_url\":\"https://img6.airdoc.com/fd16a_v2_899652817875_pst_OD_20210417050231.jpg?sign=308dec70c279183c3671e2c75a320606&t=6105ff8e\",\"created\":\"2021-04-17 05:02:34\",\"equipment\":\"fd16\",\"origin_opt_url\":\"https://img6.airdoc.com/fd16a_v2_899652817875_pst_OD_20210417050231.jpg\",\"src\":\"https://img6.airdoc.com/fd16a_v2_899652817875_pst_OD_20210417050231.jpg?sign=308dec70c279183c3671e2c75a320606&t=6105ff8e\",\"status\":\"1\",\"vessel_gray_image\":\"https://img3.airdoc.com/FD16_vessel_seg_837b2c9f545a0574ffc311c5fa157679.jpg?v=190403\",\"render\":{\"inpainting\":1,\"origin\":\"http://img.airdoc.com/SEG_ENSEMBLE_origin_549e3eb2cce1479ba56ed57819380aa2.jpg\"}},{\"img_id\":\"7720851\",\"type\":\"1\",\"w\":800,\"h\":658,\"md5bin\":\"ad6019062170d114459f46ea41e2473f\",\"score\":\"0\",\"report_url\":\"\",\"brighten\":\"\",\"watermark_url\":\"https://img6.airdoc.com/fd16a_v2_899652817875_pst_OS_20210417050315.jpg?sign=6f3b363f03305cf7e62f247031fb6ff3&t=6105ff8e\",\"created\":\"2021-04-17 05:03:19\",\"equipment\":\"fd16\",\"origin_opt_url\":\"https://img6.airdoc.com/fd16a_v2_899652817875_pst_OS_20210417050315.jpg\",\"src\":\"https://img6.airdoc.com/fd16a_v2_899652817875_pst_OS_20210417050315.jpg?sign=6f3b363f03305cf7e62f247031fb6ff3&t=6105ff8e\",\"status\":\"1\",\"vessel_gray_image\":\"https://img3.airdoc.com/FD16_vessel_seg_ad6019062170d114459f46ea41e2473f.jpg?v=190403\",\"render\":{\"inpainting\":1,\"mask\":\"http://img.airdoc.com/SEG_ENSEMBLE_seg_leopard_mask_d7477513676c4f76b44c5e88ce810b1a.png\",\"origin\":\"http://img.airdoc.com/SEG_ENSEMBLE_origin_51fcc2df54b1401d9d5c1a9d7bae21b6.jpg\"}}],\"print_popup\":0,\"patient\":{\"patient_id\":\"4102625\",\"uuid\":\"899652817875\",\"guid\":\"\",\"name\":\"姜殿绪\",\"name_upload\":\"\",\"name_import\":\"\",\"gender\":\"1\",\"birthday\":\"1947-01-01\",\"extra\":{\"medical_history\":\"1,18\"},\"org_id\":\"40166\",\"hospid\":\"\",\"status\":\"1\",\"package_type\":\"0\",\"created\":\"2021-04-17 05:01:29\",\"updated\":\"1971-01-01 00:00:00\",\"receive_base_time\":\"0000-00-00 00:00:00\",\"address\":\"\",\"id_type\":\"1\",\"email\":\"\",\"insurance_text\":{\"customer_manager_id\":\"15642672286\"},\"company\":\"\",\"industry\":\"0\",\"height\":\"167\",\"weight\":\"75\",\"answers\":\"\",\"extra_json\":{\"od_diopter\":\"-1\",\"os_diopter\":\"-1\"},\"medical_record_no\":\"\",\"age\":74,\"has_idcard\":0,\"age_snapshot\":74,\"bmi\":\"26.89\",\"medical_history_text\":\"糖尿病，不近视\",\"extra_info\":[]},\"custom_fields\":[],\"patient_code\":{\"id\":\"2817875\",\"pcode\":\"899652817875\",\"openid\":\"oYOrv5sNNBFAvakfKSNS3ELdSJOo\",\"check_id\":\"3895514\",\"slitlamp_id\":\"0\",\"visionx_id\":\"0\",\"org_id\":\"40166\",\"patient_id\":\"4102625\",\"created\":\"2021-04-17 04:59:13\",\"updated\":\"2021-04-17 05:03:20\",\"push_type\":\"0\",\"type\":\"0\",\"new_wechat\":\"3\",\"user_id\":\"10316\"},\"hide_vision\":\"0\",\"hide_wording\":\"0\",\"hide_customer_service\":\"0\",\"icvd_risk_items\":[],\"remote_review\":\"0\",\"customer_id\":\"15\",\"health_condition\":[{\"name\":\"糖代谢视网膜\",\"intro\":[\"无糖代谢视网膜相关表现，建议继续保持良好的饮食习惯\",\"补充大豆磷脂、蜂胶等有助于预防糖代谢视网膜风险\"],\"idx\":0,\"key\":\"dr\"},{\"name\":\"血管\",\"intro\":[\"无血管硬化相关表现，建议继续保持良好的生活习惯\",\"补充辅酶Q10、鱼油等有助于预防血管硬化\"],\"idx\":0,\"key\":\"presure\"},{\"name\":\"黄斑\",\"intro\":[\"无黄斑老化相关表现，建议继续保持良好的用眼习惯\",\"补充叶黄素、维生素A等有助于预防黄斑老化\"],\"idx\":0,\"key\":\"macula\"},{\"name\":\"视网膜老化\",\"intro\":[\"用眼过度引起的视网膜老化表现，可能导致视力的下降\",\"推荐：叶黄素、维生素D、花青素等\"],\"idx\":1,\"key\":\"retina\"}],\"history_diff_option\":\"first\",\"display_disease_name\":\"0\",\"hide_ins_plan\":\"0\",\"show_risk_tags\":\"1\",\"recheck_time_switch\":\"2\",\"comprehensive_switch\":[\"exemption\"],\"hxt_plus_agent\":\"0\",\"detection_img\":\"\",\"airdoc_logo\":\"3\",\"print_photo\":\"0\",\"show_report_qrcode\":\"1\",\"new_template\":\"0\",\"diseases\":\"\",\"btn_print_img\":\"3\",\"list_in_home\":\"0\",\"display_doctor_review\":\"0\",\"display_download\":0,\"switch_quantify\":\"\",\"telephone\":\"400-100-3999\",\"switch_history_diff\":\"1\",\"report_title\":\"众佑健康评估报告\",\"switch_health_examination\":\"0\",\"switch_suggestion\":\"1\",\"switch_retina_risk\":\"0\",\"blur_reminder\":\"1\",\"buy_button\":0,\"print_type\":\"1\",\"org_name\":\"高济药店\",\"operator_id\":\"77\",\"sales_id\":\"1\",\"print_button\":\"1\",\"logo\":\"http://img6.airdoc.com/4aa769c931de65af876eeee19463f0b6.png?sign=2fda9f1c2c2b23e15cac899fe0639b38&t=61091157\",\"page_num_type\":\"5\",\"insurance_multi\":\"0\",\"open_hrd\":\"0\",\"hide_footer\":\"0\",\"org_type\":\"1\",\"is_anterior\":\"0\",\"is_visionx\":\"0\",\"has_third_id\":\"\",\"province\":\"1\",\"fold\":\"1\",\"is_retina\":1,\"is_fd16\":2,\"is_third\":0,\"is_huixintong\":0,\"is_zhongyou\":1,\"is_yingtong_h5\":0,\"is_yingtong\":0,\"suggestion_type\":\"default\",\"is_gaoji\":1,\"photo_print\":0,\"has_od\":1,\"has_os\":1,\"sub_retina_age\":\"48\",\"check_user_name\":\"\",\"local_signature\":\"\",\"check_expert_name\":\"\",\"status_text\":[\"如有症状，需要就医\",\"报告可打印\"],\"hide_image\":0,\"double_bad_not_retina\":0,\"double_bad\":0,\"double_bad_fd16\":0,\"ikang_wording_1\":{\"suggestion_level\":2,\"recheck_time\":\"建议下一次复查时间：2021年5月\",\"recheck_time_v2\":\"2021.05.17\",\"od_general_health\":0,\"os_general_health\":0,\"not_found_tags\":[]},\"total_score\":0,\"lesion_level\":0,\"heat_switch\":2,\"heat_switch_item\":true,\"evaluate\":\"\",\"display_print\":1,\"lack_img\":0,\"is_blur\":0,\"origin_package_type\":1,\"final_report\":0,\"show_fuzzy_search\":0,\"report_qrcode_url\":\"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEh8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyeWlzN1FPd0dmTEMxYm9GSXh4MWkAAgTYHAVhAwQAjScA\",\"showqrcode_url\":\"https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQEh8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyeWlzN1FPd0dmTEMxYm9GSXh4MWkAAgTYHAVhAwQAjScA\",\"use_uniq_qr\":1,\"h5_entry\":{\"qr_expiry_words\":[\"2021年08月30日前扫码有效\",\"如果二维码失效请联系电话客服\"],\"attract\":[\"扫描左侧二维码\",\"下载电子报告\"]},\"display_check\":0,\"unknown_package\":0,\"fast_print\":0,\"is_yingtong_pdf\":0,\"age\":74,\"age_difference\":10,\"age_level\":70,\"age_sub\":4,\"retina_age_different\":26,\"retina_age_level\":1,\"retina_age_score\":1,\"dr_severe\":-1,\"display_other_history\":\"0\",\"open_hrd_last\":false,\"report_free_text\":\"\",\"push_type\":\"0\",\"simple_h5\":0,\"is_young\":0,\"show_promote\":0,\"upgrade_type\":0,\"single_bad\":0,\"diabetic_history\":1,\"bmi\":26.890000000000001,\"new_risk_summary\":\"\",\"new_risky\":[{\"risky_peer\":\"57.62\",\"risky_average\":\"83.00\",\"risky\":64,\"idx\":\"presure\",\"risky_level\":3,\"risky_multiple\":0.77000000000000002,\"compare\":\"lower\",\"risky_tag\":\"中高风险\",\"wording_id\":\"11\",\"detail\":[{\"show\":true,\"type\":\"INTRO\",\"display_name\":\"简介\",\"content\":[\"由于身体老化或身体机能的改变导致动脉壁弹性丢失，动脉弹性的改变是心脑血管功能发生改变的诱因，多见于40岁以上的中老年人，且呈年轻化趋势。血脂异常、血压异常、长期紧张、糖尿病、肥胖及部分自身免疫性疾病，也会引起血管压力变化，在视网膜上引发和高血压类似的血管压力变化表现，因此这些人群也会提示血管压力变化的风险。\"]},{\"show\":true,\"type\":\"FACTOR\",\"display_name\":\"引发原因\",\"content\":[{\"title\":\"钠盐摄入过多。\",\"content\":\"钠盐会引起血容量增加，诱发高血压。\"},{\"title\":\"超重和肥胖。\",\"content\":\"肥胖容易引起血液粘稠度增高，增大对血管壁的压力。\"},{\"title\":\"长期精神紧张。\",\"content\":\"引起交感神经过度兴奋诱发高血压。\"},{\"title\":\"遗传因素。\",\"content\":\"高血压家族史会提高患高血压的概率。\"}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/05dc2235-4bc8-45bd-b357-84bd0c8eea30.png\",\"type\":\"ADVICE\",\"display_name\":\"预防建议\",\"content\":[{\"type\":\"DIET\",\"title\":\"饮食\",\"content\":[{\"title\":\"少吃盐。\",\"content\":\"每天摄入食盐在6克以内，少吃含盐高的调味品。80%的中国人日均盐摄入量大于12.5克。\"},{\"title\":\"少吃肥肉和动物内脏。\",\"content\":\"其它肉类每天不应超过1-2两。\"},{\"title\":\"少喝酒。\",\"content\":\"高血压5%-10%是过量饮酒引起的。每日酒精摄入量男性不应超过25克；女性不应超过15克。\"}]},{\"type\":\"SPORT\",\"title\":\"运动\",\"content\":[{\"title\":\"每周保持中等强度运动4-7次。\",\"content\":\"每次持续30-60分钟。每周应有1次以上的有氧运动，如步行、慢跑、骑车、游泳、做健美操、跳舞和非比赛性划船等。\"}]},{\"type\":\"WEIGHT\",\"title\":\"体重\",\"content\":[{\"title\":\"控制BMI。\",\"content\":\"成年人正常体质指数(BMI)为18.5-23.9，在24-27.9为超重，提示需要控制体重；BMI>28为肥胖，需要减重。BMI>24的人群发生高血压的风险是体重正常者的3~4倍。\"},{\"title\":\"控制腰围。\",\"content\":\"男性腰围大于90cm、女性腰围大于85cm者，发生高血压的风险是腰围正常者的4倍以上。\"}]},{\"type\":\"MOOD\",\"title\":\"心理\",\"content\":[{\"title\":\"缓解紧张情绪。\",\"content\":\"人在紧张、愤怒、压抑、焦虑等状态下，血压上升。精神紧张者发生高血压的风险是正常人群的1.5倍左右。\"}]},{\"type\":\"POLLUTION\",\"title\":\"吸烟与空气污染\",\"content\":[{\"title\":\"不吸烟，减少被动吸烟。\",\"content\":\"吸烟约占男性心血管疾病负担的1/3。\"},{\"title\":\"保持室内PM2.5在优良（<75μg/m³）。\",\"content\":\"可使用空气净化器等设备。如果室外空气质量差，减少室外活动时间，做好防护。PM浓度每增加10μg/m3，高血压患病风险增加14%，超重和肥胖者风险更高。\"}]}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/60f9472e-cf5e-4fd4-a5e9-827bf4258445.png\",\"type\":\"SYMPTOM\",\"display_name\":\"常见表现\",\"content\":[\"头晕\",\"头痛\",\"胸闷心慌\",\"失眠\",\"肢体麻木\"]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/e8cd4394-388d-4d96-a949-7bab4875be4c.png\",\"type\":\"SYMPTOM\",\"display_name\":\"高发地区\",\"content\":[\"北京\",\"天津\",\"上海\",\"辽宁\",\"云南\"]}],\"name\":\"血管压力变化风险\",\"advice\":\"\"},{\"risky_peer\":\"15.00\",\"risky_average\":\"88.00\",\"risky\":84,\"idx\":\"dr\",\"risky_level\":4,\"risky_multiple\":0.94999999999999996,\"compare\":\"lower\",\"risky_tag\":\"高风险\",\"wording_id\":\"14\",\"detail\":[{\"show\":true,\"type\":\"INTRO\",\"display_name\":\"简介\",\"content\":[\"糖是人体的供能物质，由于糖代谢环节中的神经体液调节发生损害，导致糖代谢失衡风险，体内糖的利用障碍可能诱发血管和神经损伤的风险。\"]},{\"show\":true,\"type\":\"FACTOR\",\"display_name\":\"引发原因\",\"content\":[{\"title\":\"遗传因素。\",\"content\":\"1/4~1/2患者有糖尿病家族史。\"},{\"title\":\"进食过多，体力活动减少。\",\"content\":\"导致的肥胖是2型糖尿病最主要的环境因素。\"},{\"title\":\"高血压、高血脂、吸烟。\",\"content\":\"都会增加糖尿病的患病风险。\"}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/2a0666f7-acdb-43ae-b22a-c620c95c6202.png\",\"type\":\"COMPLICATION\",\"display_name\":\"常见并发症\",\"content\":{\"print_img\":\"https://img3.airdoc.com/staticResources/pharmacy/static/print_dr2.png\",\"background_img\":\"https://img3.airdoc.com/staticResources/pharmacy/static/background_dr.png\",\"title\":[\"https://img3.airdoc.com/staticResources/pharmacy/static/diabetesCourseItem1.png\",\"https://img3.airdoc.com/staticResources/pharmacy/static/diabetesCourseItem2.png\",\"https://img3.airdoc.com/staticResources/pharmacy/static/diabetesCourseItem3.png\",\"https://img3.airdoc.com/staticResources/pharmacy/static/diabetesCourseItemFix5.png\",\"https://img3.airdoc.com/staticResources/pharmacy/static/diabetesCourseItem4.png\",\"https://img3.airdoc.com/staticResources/pharmacy/static/diabetesCourseItem6.png\"],\"content\":[{\"title\":\"糖尿病足。\",\"content\":\"常见表现一开始是下肢发凉、麻木、疼痛，接着是溃烂、坏死、截肢。截肢后5年患者的生存率仅44%。\"},{\"title\":\"糖尿病合并冠心病。\",\"content\":\"糖尿病患者发生心血管问题的危险性较一般人群增加2-4倍，并且发病年龄提前。缺血性心脏病占糖尿病患者死亡的60%-80%。\"},{\"title\":\"糖尿病合并脑血管病。\",\"content\":\"病变主要包括引起脑组织内微血管和大血管的动脉粥样硬化，引起脑部的血流供应障碍，约占糖尿病患者死亡的10%。\"},{\"title\":\"糖尿病视网膜病变。\",\"content\":\"糖尿病微血管损伤，导致视力下降、视野缺损，严重者会导致失明。糖尿病人失明发生率增加25倍。\"},{\"title\":\"糖尿病神经病变。\",\"content\":\"糖尿病的慢性并发症之一，早期表现为四肢远端的感觉异常、麻木、触觉敏感性下降甚至完全丧失。\"},{\"title\":\"糖尿病肾病。\",\"content\":\"糖尿病肾病一般占糖尿病患者死亡总数的10%-30%。与非糖尿病人比，尿毒症的发生率增加17倍。\"}]}},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/05dc2235-4bc8-45bd-b357-84bd0c8eea30.png\",\"type\":\"ADVICE\",\"display_name\":\"预防建议\",\"content\":[{\"type\":\"DIET\",\"title\":\"饮食\",\"content\":[{\"title\":\"多吃膳食纤维，少吃盐。\",\"content\":\"包括豆类、富含纤维的谷物类(燕麦、山药等)、水果、蔬菜。每天摄入食盐在6克以内。\"}]},{\"type\":\"SPORT\",\"title\":\"运动\",\"content\":[{\"title\":\"坚持有氧运动。\",\"content\":\"建议每周⾄少150分钟中等强度(50%~70%最⼤⼼率)的有氧运动。如⽆禁忌症，每周建议进⾏2~3次抗阻运动，如哑铃、沙袋、弹簧、橡⽪筋等，（两次锻炼间隔≥48⼩时）。抗阻运动和有氧运动结合，可获得更⼤程度的代谢改善。\"}]},{\"type\":\"WEIGHT\",\"title\":\"体重\",\"content\":[{\"title\":\"维持健康体重。\",\"content\":\"成年人正常体质指数为18.5~23.9kg/m²，24~27.9kg/m²为超重，需控制体重；BMI>28kg/m² 为肥胖，应减重。\"},{\"title\":\"控制腰围。\",\"content\":\"警惕隐形肥胖：男性腰围大于90cm、女性腰围大于85cm者更易得糖尿病。\"}]},{\"type\":\"SMOKING\",\"title\":\"吸烟\",\"content\":[{\"title\":\"停止吸烟，远离二手烟。\",\"content\":\"吸烟会增加肿瘤、糖尿病、糖尿病大血管病变、糖尿病微血管病变、和过早死亡的风险。随着吸烟量的增加，空腹血糖和糖化血红蛋白会上升。\"}]}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/60f9472e-cf5e-4fd4-a5e9-827bf4258445.png\",\"type\":\"SYMPTOM\",\"display_name\":\"常见表现\",\"content\":[\"口渴多饮\",\"多尿\",\"食欲增加\",\"消瘦\",\"血糖升高\"]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/e8cd4394-388d-4d96-a949-7bab4875be4c.png\",\"type\":\"SYMPTOM\",\"display_name\":\"高发地区\",\"content\":[\"北京\",\"上海\",\"天津\",\"广东\",\"重庆\"]}],\"name\":\"糖代谢风险\",\"advice\":\"\"},{\"risky_peer\":\"47.502\",\"risky_average\":\"25.00\",\"risky\":33,\"idx\":\"heart\",\"risky_level\":2,\"risky_multiple\":1.3200000000000001,\"compare\":\"higher\",\"risky_tag\":\"中低风险\",\"wording_id\":\"13\",\"detail\":[{\"show\":true,\"type\":\"INTRO\",\"display_name\":\"简介\",\"content\":[\"由于心肌长期缺血而引发的心肌坏死。心肌受损是诱发心源性猝死的常见原因，死亡率正逐年上升。\"]},{\"show\":true,\"type\":\"FACTOR\",\"display_name\":\"引发原因\",\"content\":[{\"title\":\"焦虑失眠。\",\"content\":\"长期精神压力大，熬夜，失眠会增加心肌梗塞的概率。\"},{\"title\":\"既往心脏疾病。\",\"content\":\"心脏疾病易诱发心肌缺血缺氧引起心肌梗塞。\"},{\"title\":\"吸烟。\",\"content\":\"\"},{\"title\":\"高血压、高血脂、糖尿病、超重、肥胖。\",\"content\":\"\"}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/05dc2235-4bc8-45bd-b357-84bd0c8eea30.png\",\"type\":\"ADVICE\",\"display_name\":\"预防建议\",\"content\":[{\"type\":\"DIET\",\"title\":\"饮食\",\"content\":[{\"title\":\"少吃盐。\",\"content\":\"每天摄入食盐在6克以内，少吃味精、酱油等含盐高的调味品。2013年中国因高盐饮食死亡约143万人，占全部死亡的15.6%。\"},{\"title\":\"多吃蔬菜水果。\",\"content\":\"每日吃蔬菜400-500g，水果100g。\"},{\"title\":\"多吃坚果。\",\"content\":\"包括花生、杏仁、核桃、巴旦木等。坚果富含不饱和脂肪酸，每天吃10克坚果, 就能显著降低人们死于心血管疾病和癌症的风险。\"},{\"title\":\"每周吃5个蛋类。\",\"content\":\"每周增加1个鸡蛋的摄入，心血管病事件发生风险降低3%，但不要超过每周6个。\"}]},{\"type\":\"WEIGHT\",\"title\":\"体重\",\"content\":[{\"title\":\"控制BMI。\",\"content\":\"成年人正常体质指数(BMI)为18.5-23.9，在24-27.9为超重，提示需要控制体重；BMI>28为肥胖，需要减重。肥胖主要是通过血压影响心血管疾病的发生，BMI每增加5，相当于收缩压升高8.3mmHg。\"}]},{\"type\":\"SPORT\",\"title\":\"运动\",\"content\":[{\"title\":\"休闲活动。\",\"content\":\"进行中等强度休闲活动(如太极拳、跳舞、健身、步行等)可以让心血管病死亡风险下降14%。每快速步行1小时，心血管病死亡风险减少12%。\"}]},{\"type\":\"POLLUTION\",\"title\":\"吸烟与空气污染\",\"content\":[{\"title\":\"\",\"content\":\"吸烟人群发生心梗的风险比非吸烟人群提高1.54倍。PM2.5浓度每增加10μg/m3患心血管病死亡风险增加22%。\"}]},{\"type\":\"OTHERS\",\"title\":\"其它\",\"content\":[{\"title\":\"\",\"content\":\"高血压人群应谨慎泡温泉和蒸桑拿，在冬季要注意保暖。\"}]}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/60f9472e-cf5e-4fd4-a5e9-827bf4258445.png\",\"type\":\"SYMPTOM\",\"display_name\":\"常见表现\",\"content\":[\"心绞痛\",\"胸闷心悸\",\"烦躁\",\"恶心呕吐\",\"心律失常\"]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/e8cd4394-388d-4d96-a949-7bab4875be4c.png\",\"type\":\"SYMPTOM\",\"display_name\":\"高发地区\",\"content\":[\"黑龙江\",\"内蒙古\",\"新疆\",\"吉林\",\"河南\"]}],\"name\":\"心血管风险\",\"advice\":\"\"},{\"risky_peer\":\"58.46\",\"risky_average\":\"30.77\",\"risky\":41,\"idx\":\"brain\",\"risky_level\":2,\"risky_multiple\":1.3300000000000001,\"compare\":\"higher\",\"risky_tag\":\"中低风险\",\"wording_id\":\"12\",\"detail\":[{\"show\":true,\"type\":\"INTRO\",\"display_name\":\"简介\",\"content\":[\"由于为大脑供血的血管发生狭窄、阻塞甚至破裂导致大脑无法得到正常的氧气供应，引起大脑功能的异常，是导致死亡和残疾的重要原因。\"]},{\"show\":true,\"type\":\"FACTOR\",\"display_name\":\"引发原因\",\"content\":[{\"title\":\"血管因素。\",\"content\":\"大脑供血的血管出现狭窄、闭塞或动脉瘤等情况，引起脑组织缺血缺氧，诱发大脑功能障碍。高血压是最主要的危险因素。\"},{\"title\":\"代谢因素。\",\"content\":\"糖类、脂类代谢异常，过度肥胖，会增加血液粘滞度，增加脑卒中风险。\"},{\"title\":\"生活习惯。\",\"content\":\"熬夜、吸烟、酗酒等不良的生活习惯也会增加脑卒中风险。\"}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/05dc2235-4bc8-45bd-b357-84bd0c8eea30.png\",\"type\":\"ADVICE\",\"display_name\":\"预防建议\",\"content\":[{\"type\":\"DIET\",\"title\":\"饮食\",\"content\":[{\"title\":\"少吃盐。\",\"content\":\"每天摄入食盐在6克以内，少吃味精、酱油等含盐高的调味品。2013年中国因高盐饮食死亡约143万人，占全部死亡的15.6%。\"},{\"title\":\"多吃蔬菜水果。\",\"content\":\"每日吃蔬菜400-500g，水果100g。\"},{\"title\":\"多吃坚果。\",\"content\":\"包括花生、杏仁、核桃、巴旦木等。坚果富含不饱和脂肪酸，每天吃10克坚果, 就能显著降低人们死于心血管疾病和癌症的风险。\"},{\"title\":\"每周吃5个蛋类。\",\"content\":\"每周增加1个鸡蛋的摄入，心血管病事件发生风险降低3%，但不要超过每周6个。\"}]},{\"type\":\"WEIGHT\",\"title\":\"体重\",\"content\":[{\"title\":\"控制BMI。\",\"content\":\"成年人正常体质指数(BMI)为18.5-23.9，24-27.9为超重，需控制体重；BMI>28为肥胖，需要减重。肥胖主要是通过血压影响心血管疾病的发生，BMI每增加5，相当于收缩压升高8.3mmHg。\"}]},{\"type\":\"SPORT\",\"title\":\"运动\",\"content\":[{\"title\":\"休闲活动。\",\"content\":\"进行中等强度休闲活动(如太极拳、跳舞、健身、步行等)可以让心血管病死亡风险下降14%。每快速步行1小时，心血管病死亡风险减少12%。\"}]},{\"type\":\"POLLUTION\",\"title\":\"吸烟与空气污染\",\"content\":[{\"title\":\"\",\"content\":\"吸烟人群发生心梗的风险比非吸烟人群提高1.54倍。PM2.5浓度每增加10μg/m3患心血管病死亡风险增加22%。\"}]},{\"type\":\"OTHERS\",\"title\":\"其它\",\"content\":[{\"title\":\"\",\"content\":\"高血压人群应谨慎泡温泉和蒸桑拿，在冬季要注意保暖。\"}]}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/60f9472e-cf5e-4fd4-a5e9-827bf4258445.png\",\"type\":\"SYMPTOM\",\"display_name\":\"常见表现\",\"content\":[\"单侧肢体无力或麻木\",\"意识障碍\",\"眩晕呕吐\",\"双眼斜视\"]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/e8cd4394-388d-4d96-a949-7bab4875be4c.png\",\"type\":\"SYMPTOM\",\"display_name\":\"高发地区\",\"content\":[\"西藏\",\"河北\",\"河南\",\"贵州\",\"黑龙江\"]}],\"name\":\"脑血管风险\",\"advice\":\"\"},{\"risky_peer\":\"22.00\",\"risky_average\":\"22.00\",\"risky\":18,\"idx\":\"anemia\",\"risky_level\":1,\"risky_multiple\":0.81000000000000005,\"compare\":\"lower\",\"risky_tag\":\"低风险\",\"wording_id\":\"16\",\"detail\":[{\"show\":true,\"type\":\"INTRO\",\"display_name\":\"简介\",\"content\":[\"血气不足是指血液运输氧气的能力下降。常见于孕妇、成年女性、身体瘦弱的人群，血气不足使得身体各器官组织无法得到充分的氧供，可能导致机体功能的异常。\"]},{\"show\":true,\"type\":\"FACTOR\",\"display_name\":\"引发原因\",\"content\":[{\"title\":\"膳食因素。\",\"content\":\"不良的烹饪习惯导致铁、叶酸、维生素B12摄入不足容易诱发贫血。\"},{\"title\":\"化学物质。\",\"content\":\"苯、除草剂、杀虫剂、染发剂的长期接触也容易诱发贫血。\"},{\"title\":\"出血。\",\"content\":\"各种急性或慢性失血，外伤、女性月经量过大、消化道出血等会导致红细胞大量丢失。\"},{\"title\":\"其他因素。\",\"content\":\"有艾滋病、病毒感染、恶性肿瘤和各种慢性病也会导致贫血。\"}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/05dc2235-4bc8-45bd-b357-84bd0c8eea30.png\",\"type\":\"ADVICE\",\"display_name\":\"预防建议\",\"content\":[{\"type\":\"DIET\",\"title\":\"饮食\",\"content\":[{\"title\":\"合理膳食。\",\"content\":\"饮食保证食物的多样性，适当增加瘦肉、动物内脏、鱼肉、血制品的摄入。\"},{\"title\":\"多吃蔬菜水果。\",\"content\":\"维生素C可以促进铁的吸收和红细胞的合成。\"},{\"title\":\"补充铁剂、叶酸和维生素B12。\",\"content\":\"建议孕妇可适当补充叶酸和维生素B12。\"}]},{\"type\":\"SPORT\",\"title\":\"运动\",\"content\":[{\"title\":\"避免剧烈活动。\",\"content\":\"贫血人群应注意休息，避免剧烈活动。\"}]},{\"type\":\"POLLUTION\",\"title\":\"生活习惯\",\"content\":[{\"title\":\"辐射防护。\",\"content\":\"避免和高能射线X线、γ射线的长期接触，穿戴防护服。\"},{\"title\":\"减少化学物质接触。\",\"content\":\"避免长期接触苯、除草剂、杀虫剂等，避免长期染发。\"}]}]},{\"show\":true,\"default_url\":\"https://img3.airdoc.com/cms/salesman/79c25278-77cf-426d-9a3c-c3572421b077.png\",\"type\":\"SYMPTOM\",\"display_name\":\"常见表现\",\"content\":[\"皮肤苍白\",\"感觉异常\",\"头晕心悸\",\"食欲缺乏\",\"异食癖\"]}],\"name\":\"血气不足风险\",\"advice\":\"\"}],\"new_risky_version\":1,\"display_health_examination\":1,\"health_examination\":[{\"name\":\"血压\",\"content\":[\"如果您目前没有高血压，建议至少每月测一次血压。<br/><strong>血压偏高：</strong>收缩压140以上，舒张压90以上。<br/><strong>血压正常高值：</strong>收缩压120~139，舒张压80~89为血压高值，正常高值人群是高血压的高危人群，需要积极调整生活方式，预防高血压。\",\"如果您是高血压患者，建议遵医嘱严格控制血压，减少并发症的发生风险。\"],\"reason\":\"您的脑血管风险风险指数为\",\"risk_tag\":\"中低风险\",\"risk_level\":2,\"times\":\"每月检查一次\"},{\"name\":\"空腹血糖\",\"content\":[\"如果您没有糖尿病，建议至少每3月测试一次空腹血糖。空腹血糖6.1以上为空腹血糖受损（糖尿病前期），需要及时开始生活干预。\",\"如果您是糖尿病患者，建议遵医嘱严格控制血糖，从而控制糖尿病性视网膜病变、糖尿病性肾病、糖尿病足等并发症的发生。\"],\"reason\":\"您的糖代谢风险风险指数为\",\"risk_tag\":\"高风险\",\"risk_level\":4,\"times\":\"每3月检查一次\"},{\"name\":\"血脂四项\",\"content\":[\"血脂四项包括：总胆固醇、甘油三酯、高密度脂蛋白胆固醇、低密度脂蛋白胆固醇。血脂偏高会大大增加心血管疾病的风险，建议至少半年检查一次血脂四项。\"],\"reason\":\"您的脑血管风险风险指数为\",\"risk_tag\":\"中低风险\",\"risk_level\":2,\"times\":\"半年检查一次\"},{\"name\":\"心电图\",\"content\":[\"心电图主要针对心脏的电活动进行检查，是临床最常用的检查之一，能够早期发现多种心脏疾病。\",\"建议半年做一次心电图检查，定期检查心脏情况，谨防心肌梗死、心肌缺血、心律失常等心脏疾病。\"],\"reason\":\"您的脑血管风险风险指数为\",\"risk_tag\":\"中低风险\",\"risk_level\":2,\"times\":\"半年检查一次\"},{\"name\":\"血常规\",\"content\":[\"血常规检查主要对红细胞系统、白细胞系统、血小板系统进行检查。多种疾病都会伴随着血常规指标的改变。\",\"建议至少半年做一个血常规检查。不仅可以及早发现贫血风险，还能早期发现血液疾病、恶性肿瘤、急性感染等多种疾病。\"],\"reason\":\"您的糖代谢风险风险指数为\",\"risk_tag\":\"高风险\",\"risk_level\":4,\"times\":\"半年检查一次\"},{\"name\":\"脑部CT或MRI\",\"content\":[\"脑部CT或MRI是通过影像学手段对大脑进行检查的方法，能够早期发现脑肿瘤、脑出血、脑梗塞等多种脑部疾病。\",\"建议每年做一次脑部影像学检查（CT或MRI），关注脑部结构细微的改变，严防脑梗、脑出血、脑肿瘤的发生。\"],\"reason\":\"您的脑血管风险风险指数为\",\"risk_tag\":\"中低风险\",\"risk_level\":2,\"times\":\"每年检查一次\"},{\"name\":\"颈动脉彩超\",\"content\":[\"颈动脉彩超室诊断、评估颈动脉病变的有效手段之一，不仅能早期发现动脉硬化、血管狭窄、血管斑块等改变，还能分析血流动力学的结果。\",\"建议每年做一次颈动脉彩超检查，及时发现颈动脉的血管及血流动力学改变，排查心脑血管风险。\"],\"reason\":\"您的脑血管风险风险指数为\",\"risk_tag\":\"中低风险\",\"risk_level\":2,\"times\":\"每年检查一次\"},{\"name\":\"超声心动图\",\"content\":[\"超声心动图可以对心脏和大血管的结构及功能状态进行检查，图像清晰且安全无创。\",\"建议每年做一次超声心动图检查，关注心脏功能，警惕心脏结构的细微改变，严防心肌梗死、冠心病、心瓣膜病等心脏疾病。\"],\"reason\":\"您的心血管风险风险指数为\",\"risk_tag\":\"中低风险\",\"risk_level\":2,\"times\":\"每年检查一次\"}],\"advice\":[{\"name\":\"饮食\",\"key\":\"food\",\"advice\":[\"您的体重已经超重，应该减少能量的摄入，减轻体重。\",\"应该严格控制糖的摄入，多摄入低GI的食物如蔬菜、豆类等。\",\"建议富钾低钠饮食，多吃富含膳食纤维的谷物、如燕麦、玉米等。\",\"控制胆固醇和饱和脂肪酸的摄入，减少动物脂肪摄入比例，增加植物性饮食。\",\"定时定量进餐，避免暴饮暴食，控制浓茶和咖啡的过量饮用。\",\"建议适当补充维生素A、B、C、E及锌、硒、镁等微量元素，有助于改善视网膜和视神经。\",\"饮水应该少量多次，单次饮水量不要超过500ml，避免眼压的升高。\",\"养成进食时细嚼慢咽的好习惯，吃饭时避免狼吞虎咽和过量进食。\",\"减少精细食物的摄入，精米细面要少吃，多吃粗粮，如高粱、荞麦等。\"]},{\"name\":\"运动\",\"key\":\"sport\",\"advice\":[\"您的体重已超重，建议以有氧运动为主，结合无氧运动，减轻体重。\",\"有氧运动可以选择太极拳、散步、广场舞、交际舞等。\",\"无氧运动可以选择强度较小的运动方式如高尔夫、乒乓球等。\",\"建议每次运动时间不少于30分钟，每周运动不少于5次。\",\"运动强度应循序渐进，量力而为，运动前进行适当热身。\",\"运动结束后避免通过凉水澡、空调、风扇等方式进行降温，应等体温恢复至正常后再洗澡。\",\"单次运动时间不宜过长，运动结束后注意适量补充水分和电解质。\"]},{\"name\":\"生活\",\"key\":\"life\",\"advice\":[\"保持积极乐观的心态，避免长期处于高度紧张的状态，保持良好的作息习惯，避免熬夜。\",\"不要吸烟，也要避免暴露于二手烟的环境中。吸烟和二手烟不仅会降低身体机能，吸烟人群发生心梗的风险比非吸烟人群提高1.5倍，还能诱发多种眼部疾病。\"]},{\"name\":\"护眼\",\"key\":\"eye\",\"advice\":[\"控制电子产品的使用时间，每天累计使用电子产品时间尽量少于4小时，字体尽量调大。\",\"保持眼部卫生，不随意揉眼，避免用眼过度疲劳，培养做眼保健操的习惯。\",\"睡觉时使头稍稍抬起，避免眼压升高，阅读时保证充足的光线，避免长时间在光线不好的条件下用眼。\",\"避免情绪的过度激动引起眼压升高，避免身体和精神的过度劳累。\",\"近视人群选择正规的验光配镜机构，及时矫正视力，避免度数加深。\",\"阅读、看电视时保持合适的距离，避免过近或过远，书本与眼睛距离以30cm为准，看电视应保持电视画面对角线6至8倍的距离。\"]}],\"hospital_init\":0,\"risk_tags\":[{\"tag\":\"糖代谢风险\",\"high\":1,\"key\":\"dr\",\"intro\":[\"常见表现：口渴多饮、多尿、食欲增加但消瘦\",\"改善：叶黄素、西洋参、维生素K2、铁皮石斛等\"]},{\"tag\":\"高龄超重人群\",\"high\":0,\"key\":\"bmi\",\"intro\":[\"可能出现皮肤苍白、感觉异常、呼吸困难等表现，诱发代谢异常、静脉血栓、心脑血管风险，增加某些肿瘤的发病率\"]},{\"tag\":\"血管压力变化风险\",\"high\":0,\"key\":\"presure\",\"intro\":[\"常见表现：头晕、头痛、胸闷心慌\",\"改善：维生素K2、卵磷脂、维生素D、三七等\"]},{\"tag\":\"心血管健康\",\"high\":0,\"key\":\"heart\",\"intro\":[\"常见表现：烦躁、恶心呕吐、心律失常、胸闷心悸\",\"改善：三七、丹参、西洋参、维生素D等\"]},{\"tag\":\"脑血管健康\",\"high\":0,\"key\":\"brain\",\"intro\":[\"常见表现：肢体无力、眩晕、呕吐\",\"改善：银杏叶、葛根、鱼油、大豆磷脂、维生素D等\"]}],\"oil_result\":\"\",\"feedback\":0,\"history_diff\":{\"disease_risk\":[{\"risk_name\":\"血管压力变化风险\",\"risk_key\":\"presure\",\"max\":64,\"min\":64,\"list\":[{\"risk_value\":64,\"risk_level\":3,\"level_name\":\"中高风险\",\"check_date\":\"2021.04.17\"},{\"check_date\":\"2021.05.17\"}],\"risk_level_grade\":[0,25,50,75,100],\"change\":\"\",\"future\":1},{\"risk_name\":\"糖代谢风险\",\"risk_key\":\"dr\",\"max\":84,\"min\":84,\"list\":[{\"risk_value\":84,\"risk_level\":4,\"level_name\":\"高风险\",\"check_date\":\"2021.04.17\"},{\"check_date\":\"2021.05.17\"}],\"risk_level_grade\":[0,25,50,75,100],\"change\":\"\",\"future\":1},{\"risk_name\":\"心血管风险\",\"risk_key\":\"heart\",\"max\":33,\"min\":33,\"list\":[{\"risk_value\":33,\"risk_level\":2,\"level_name\":\"中低风险\",\"check_date\":\"2021.04.17\"},{\"check_date\":\"2021.05.17\"}],\"risk_level_grade\":[0,25,50,75,100],\"change\":\"\",\"future\":1},{\"risk_name\":\"脑血管风险\",\"risk_key\":\"brain\",\"max\":41,\"min\":41,\"list\":[{\"risk_value\":41,\"risk_level\":2,\"level_name\":\"中低风险\",\"check_date\":\"2021.04.17\"},{\"check_date\":\"2021.05.17\"}],\"risk_level_grade\":[0,25,50,75,100],\"change\":\"\",\"future\":1},{\"risk_name\":\"血气不足风险\",\"risk_key\":\"anemia\",\"max\":18,\"min\":18,\"list\":[{\"risk_value\":18,\"risk_level\":1,\"level_name\":\"低风险\",\"check_date\":\"2021.04.17\"},{\"check_date\":\"2021.05.17\"}],\"risk_level_grade\":[0,25,50,75,100],\"change\":\"\",\"future\":1}],\"retina_disease\":\"\",\"comprehensive_risk\":[{\"check_id\":3895514}],\"preposition\":0},\"history_pack_up\":0,\"display_exemption\":1,\"server_time\":\"2021-07-31 17:53:37\",\"is_leader\":0,\"open_upload_name\":1,\"is_superuser\":0,\"is_taiping\":0,\"pdf_url\":\"https://pe.airdoc.com/api/checklist/getPdf?en_check_id=MDcyNDc2OGQtMTE1ZC00N2ZiLWFhY2EtNzczNzRkZWEzODBjSezFGC8Ps7M5ECBMQhgfNw%2BaRLDcQEQhMkYeY7NyTZg097Y%3D&sign=549c1fdf0ff83ed46ac532cafb594d99\",\"family\":\"\",\"xanthophyll\":[],\"is_continuous_monitoring\":0}\n";
        Object obj = JSON.parse(json, Feature.OrderedField);
        dfs(obj, "");
        System.out.println(obj);


    }

    // 1. 参数和返回值
    // 2. 终止条件
    // 3. 单层递归逻辑
    public static void dfs(Object obj, String pre) {
        if (obj instanceof JSONObject) {
            JSONObject job = (JSONObject) obj;
            Set<String> keys = job.keySet(); //获取所有的key
            List<String> kList = new ArrayList<>(keys);
            for (String k : kList) {
                // 修改key
                Object child = job.get(k);
                String curKey = pre.isEmpty() ? k : pre + "_" + k;
                job.remove(k);
                job.put(curKey, child);
                dfs(child, curKey);
            }
        } else if (obj instanceof JSONArray) {
            JSONArray jArr = (JSONArray) obj;
            for (int i = 0; i < jArr.size(); i++) {
                Object to = jArr.get(i);
                dfs(to, pre);
            }
        } else {
            return;
        }
    }
}
