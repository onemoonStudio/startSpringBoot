package com.example.boot4;

import com.example.boot4.Persistence.MemberRepository;
import com.example.boot4.Persistence.ProfileRepository;
import com.example.boot4.domain.Member;
import com.example.boot4.domain.Profile;
import lombok.extern.java.Log;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit // 테스트 결과를 DB 에 커밋
public class ProfileTests {

    @Autowired
    MemberRepository memberRepo;

    @Autowired
    ProfileRepository profileRepo;

    @Test
    public void testInsertMembers() {
        IntStream.range(1, 101).forEach(i -> {
            Member member = new Member();
            member.setUid("User" + i);
            member.setUname("사용자_" + i);
            member.setUpw("pw_" + i);
            memberRepo.save(member);
        });
    }

    @Test
    public void testInsertProfile() {
        Member member = new Member();
        member.setUid("User1");

        for (int i = 1; i < 5; i++) {
            Profile profile1 = new Profile();
            profile1.setFname("face" + i + ".jpg");

            if (i == 1) {
                profile1.setCurrent(true);
            }
            profile1.setMember(member);
            profileRepo.save(profile1);
        }

    }

    @Test
    public void testFetchJoin() {
        List<Object[]> result = memberRepo.getMemberWithProfileCount("User1");

        result.forEach(arr -> {
            System.out.println(Arrays.toString(arr));
        });
    }

    @Test
    public void testFetchJoin2() {

        List<Object[]> result = memberRepo.getMemberWithProfile("User1");

        result.forEach(arr -> System.out.println(Arrays.toString(arr)));

    }

}
