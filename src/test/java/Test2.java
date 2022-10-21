//package com.deepexi.aiot.env.dct.psc.transcation;
//
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.deepexi.aiot.env.dct.psc.commons.record.*;
//import com.deepexi.aiot.env.dct.psc.commons.record.cols.*;
//
//import java.sql.JDBCType;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class RecordTransformEngine {
//    // record封装函数
//    public Record process(Record record) {
//        ArrayList<RowData> rowDataArrayDest = new ArrayList<>();
//        ArrayList<ColumnMetaData> metaDataArrayDest = new ArrayList<>();
//        // 解析Json
//        ArrayList<RowData> rowDataArray =  record.getData().getAll();
//        for (RowData rowData : rowDataArray) {
//            List<Column> columnList = rowData.getAll();
//            for (Column column : columnList) {
//                if (column instanceof JSONColumn) {
//                    // 获取Json
//                    String JsonStr = column.getRawData().toString();
//                    // 用户自定义json解析逻辑
//                    JSONObject jo = JSONObject.parseObject(JsonStr);
//                    JSONArray jsonArray = jo.getJSONArray("datas");
//                    int jsonArraySize = jsonArray.size();
//                    System.out.println(jsonArraySize);
//
//                }
//            }
//            return new Record(record.getHeader(), record.getOperation(), record.getDdl(), record.getLocation(), new RecordData(metaDataArrayDest, rowDataArrayDest));
//
//        }
//        return new Record(record.getHeader(), record.getOperation(), record.getDdl(), record.getLocation(),
//                new RecordData(metaDataArrayDest, rowDataArrayDest));
//    }
//}