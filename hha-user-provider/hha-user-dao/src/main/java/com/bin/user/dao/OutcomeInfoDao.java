package com.bin.user.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bin.user.pojo.PO.OutcomeInfo;
import com.bin.user.pojo.PO.RoutineInfo;
import com.bin.user.pojo.PO.TypeInfo;
import com.bin.user.pojo.VO.TypeInfoVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author tageshi
 * @date 2023/3/17 13:41
 */
public interface OutcomeInfoDao extends BaseMapper<OutcomeInfo> {
    Integer insertOutcomeRecord(@Param("typeId")Long typeId,
                                @Param("outcomeName")String outcomeName,
                                @Param("outcome")Float outcome,
                                @Param("date")Date date,
                                @Param("userId")Long userId);

    @Options(useGeneratedKeys = true, keyProperty = "typeId", keyColumn = "type_id")
    @Insert(" insert into type_info(type_name,type_icon)values (#{type.typeName},#{type.typeIcon})")
    Integer insertDefinedType(@Param("type")TypeInfo type);
    Integer insertUserType(@Param("userId")Long userId,@Param("typeId")Long typeId);
    List<TypeInfoVO> getTypeList();
    List<TypeInfoVO> getDefinedTypeList(@Param("userId")Long userId);
    Integer deleteCascadeType(@Param("typeId")Long typeId);
    Integer deleteOneType(@Param("typeId")Long typeId);
    Integer updateOutcomeRecord(@Param("outcomeId")Long outcomeId,
                                @Param("typeId")Long typeId,
                                @Param("outcomeName")String outcomeName,
                                @Param("outcome")Float outcome,
                                @Param("date")Date date);
    Integer deleteOutcomeRecord(@Param("outcomeId")Long outcomeId);
    @Options(useGeneratedKeys = true, keyProperty = "routine.routineId", keyColumn = "routine_info.routine_id")
    @Insert("insert into routine_info(routine_name,routine_icon,user_id) values (#{routine.routineName},#{routine.routineIcon},#{userId})")
    Integer addConsumeRoutine(@Param("routine")RoutineInfo routine, @Param("userId")Long userId);
    Integer addRoutineDetail(@Param("detailName")String detailName,
                             @Param("detailTypeId")Long detailTypeId,
                             @Param("detailCost")Float detailCost,
                             @Param("routineId")Long routineId);
}
