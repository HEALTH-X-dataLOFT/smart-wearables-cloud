package com.medisanaspace.healthx.dataloft.smartwearables.domain;

import com.medisanaspace.DataBootApplication;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLinkService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.ThryveClient;
import com.medisanaspace.healthx.dataloft.smartwearables.keycloak.KeycloakClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = DataBootApplication.class
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class GarminApiWebHookControllerIT {

    public static final String USER_TOKEN = UUID.randomUUID().toString();

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @MockitoBean
    ActivityProviderAccountLinkService linkService;

    @MockitoBean
    private ClientRegistrationRepository clientRegistrationRepository;

    @MockitoBean
    private KeycloakClient keycloakClient;

    @MockitoBean
    private ThryveClient thryveClient;

    @BeforeEach
    void setup() {
        User user = new User();
        user.setKeycloakId(UUID.randomUUID());
        user = userService.save(user);
        doReturn(user).when(linkService).getUserForToken(USER_TOKEN);
    }

    @Test
    void pushActivitiesWebhook() throws Exception {
        mockMvc.perform(
                post("/garmin-api/push/activities")
                        .header("user-agent", "Garmin Health API")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"activities\": [\n" +
                                "    {\n" +
                                "      \"userId\": \"4aacafe82427c251df9c9592d0c06768\",\n" +
                                "      \"summaryId\": \"x153a9f3-5a9478d4-5\",\n" +
                                "      \"userAccessToken\": \"" + USER_TOKEN + "\",\n" +
                                "      \"activityId\": 5001968355,\n" +
                                "      \"activityName\": \"string\",\n" +
                                "      \"activityDescription\": \"string\",\n" +
                                "      \"isParent\": true,\n" +
                                "      \"parentSummaryId\": \"string\",\n" +
                                "      \"durationInSeconds\": 1789,\n" +
                                "      \"startTimeInSeconds\": 1512234126,\n" +
                                "      \"startTimeOffsetInSeconds\": -25200,\n" +
                                "      \"activityType\": \"RUNNING\",\n" +
                                "      \"averageBikeCadenceInRoundsPerMinute\": 0,\n" +
                                "      \"averageHeartRateInBeatsPerMinute\": 144,\n" +
                                "      \"averageRunCadenceInStepsPerMinute\": 84,\n" +
                                "      \"averagePushCadenceInPushesPerMinute\": 80,\n" +
                                "      \"averageSpeedInMetersPerSecond\": 2.781,\n" +
                                "      \"averageSwimCadenceInStrokesPerMinute\": 0,\n" +
                                "      \"averagePaceInMinutesPerKilometer\": 15.521924,\n" +
                                "      \"activeKilocalories\": 367,\n" +
                                "      \"deviceName\": \"forerunner935\",\n" +
                                "      \"distanceInMeters\": 1976.83,\n" +
                                "      \"maxBikeCadenceInRoundsPerMinute\": 0,\n" +
                                "      \"maxHeartRateInBeatsPerMinute\": 159,\n" +
                                "      \"maxPaceInMinutesPerKilometer\": 10.396549,\n" +
                                "      \"maxRunCadenceInStepsPerMinute\": 106,\n" +
                                "      \"maxPushCadenceInPushesPerMinute\": 75,\n" +
                                "      \"maxSpeedInMetersPerSecond\": 4.152,\n" +
                                "      \"numberOfActiveLengths\": 0,\n" +
                                "      \"startingLatitudeInDegree\": 51.053232522681355,\n" +
                                "      \"startingLongitudeInDegree\": -114.06880217604339,\n" +
                                "      \"steps\": 5022,\n" +
                                "      \"pushes\": 1000,\n" +
                                "      \"totalElevationGainInMeters\": 16,\n" +
                                "      \"totalElevationLossInMeters\": 22,\n" +
                                "      \"manual\": true\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void pushActivityDetailsWebhook() throws Exception {
        mockMvc.perform(
                post("/garmin-api/push/activity-details")
                        .header("user-agent", "Garmin Health API")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"activityDetails\": [\n" +
                                "    {\n" +
                                "      \"userId\": \"4aacafe82427c251df9c9592d0c06768\",\n" +
                                "      \"summaryId\": \"x153a9f3-5a9478d4-7\",\n" +
                                "      \"userAccessToken\": \"" + USER_TOKEN + "\",\n" +
                                "      \"activityId\": 5001968355,\n" +
                                "      \"summary\": {\n" +
                                "        \"userId\": \"4aacafe82427c251df9c9592d0c06768\",\n" +
                                "        \"summaryId\": \"x153a9f3-5a9478d4-7\",\n" +
                                "        \"activityId\": 5001968355,\n" +
                                "        \"activityName\": \"string\",\n" +
                                "        \"activityDescription\": \"string\",\n" +
                                "        \"isParent\": true,\n" +
                                "        \"parentSummaryId\": \"string\",\n" +
                                "        \"durationInSeconds\": 1789,\n" +
                                "        \"startTimeInSeconds\": 1512234126,\n" +
                                "        \"startTimeOffsetInSeconds\": -25200,\n" +
                                "        \"activityType\": \"RUNNING\",\n" +
                                "        \"averageBikeCadenceInRoundsPerMinute\": 0,\n" +
                                "        \"averageHeartRateInBeatsPerMinute\": 144,\n" +
                                "        \"averageRunCadenceInStepsPerMinute\": 84,\n" +
                                "        \"averagePushCadenceInPushesPerMinute\": 80,\n" +
                                "        \"averageSpeedInMetersPerSecond\": 2.781,\n" +
                                "        \"averageSwimCadenceInStrokesPerMinute\": 0,\n" +
                                "        \"averagePaceInMinutesPerKilometer\": 15.521924,\n" +
                                "        \"activeKilocalories\": 367,\n" +
                                "        \"deviceName\": \"forerunner935\",\n" +
                                "        \"distanceInMeters\": 1976.83,\n" +
                                "        \"maxBikeCadenceInRoundsPerMinute\": 0,\n" +
                                "        \"maxHeartRateInBeatsPerMinute\": 159,\n" +
                                "        \"maxPaceInMinutesPerKilometer\": 10.396549,\n" +
                                "        \"maxRunCadenceInStepsPerMinute\": 106,\n" +
                                "        \"maxPushCadenceInPushesPerMinute\": 75,\n" +
                                "        \"maxSpeedInMetersPerSecond\": 4.152,\n" +
                                "        \"numberOfActiveLengths\": 0,\n" +
                                "        \"startingLatitudeInDegree\": 51.053232522681355,\n" +
                                "        \"startingLongitudeInDegree\": -114.06880217604339,\n" +
                                "        \"steps\": 5022,\n" +
                                "        \"pushes\": 1000,\n" +
                                "        \"totalElevationGainInMeters\": 16,\n" +
                                "        \"totalElevationLossInMeters\": 22,\n" +
                                "        \"manual\": true\n" +
                                "      },\n" +
                                "      \"samples\": [\n" +
                                "        {\n" +
                                "          \"startTimeInSeconds\": 1512234126,\n" +
                                "          \"latitudeInDegree\": 51.053232522681355,\n" +
                                "          \"longitudeInDegree\": -114.06880217604339,\n" +
                                "          \"elevationInMeters\": 1049.4000244140625,\n" +
                                "          \"airTemperatureCelcius\": 28,\n" +
                                "          \"heartRate\": 83,\n" +
                                "          \"speedMetersPerSecond\": 0,\n" +
                                "          \"stepsPerMinute\": 57,\n" +
                                "          \"totalDistanceInMeters\": 0.17000000178813934,\n" +
                                "          \"powerInWatts\": 0,\n" +
                                "          \"bikeCadenceInRPM\": 0,\n" +
                                "          \"swimCadenceInStrokesPerMinute\": 0,\n" +
                                "          \"wheelChairCadenceInPushesPerMinute\": 0,\n" +
                                "          \"timerDurationInSeconds\": 0,\n" +
                                "          \"clockDurationInSeconds\": 0,\n" +
                                "          \"movingDurationInSeconds\": 0\n" +
                                "        }\n" +
                                "      ],\n" +
                                "      \"laps\": [\n" +
                                "        {\n" +
                                "          \"startTimeInSeconds\": 1512234126\n" +
                                "        }\n" +
                                "      ]\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void pushDailiesWebhook() throws Exception {
        mockMvc.perform(
                post("/garmin-api/push/dailies")
                        .header("user-agent", "Garmin Health API")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"dailies\": [\n" +
                                "        {\n" +
                                "            \"userId\": \"57823f87-9c77-4ec3-a84d-74e943b6a7ee\",\n" +
                                "            \"userAccessToken\": \"" + USER_TOKEN + "\",\n" +
                                "            \"summaryId\": \"sd4f748fa-65a02a0c-ab54-0\",\n" +
                                "            \"calendarDate\": \"2024-01-11\",\n" +
                                "            \"activityType\": \"GENERIC\",\n" +
                                "            \"activeKilocalories\": 40,\n" +
                                "            \"bmrKilocalories\": 69,\n" +
                                "            \"steps\": 210,\n" +
                                "            \"pushes\": 1336,\n" +
                                "            \"distanceInMeters\": 332.22,\n" +
                                "            \"pushDistanceInMeters\": 221.93,\n" +
                                "            \"durationInSeconds\": 43860,\n" +
                                "            \"activeTimeInSeconds\": 393,\n" +
                                "            \"startTimeInSeconds\": 1704995340,\n" +
                                "            \"startTimeOffsetInSeconds\": -21600,\n" +
                                "            \"moderateIntensityDurationInSeconds\": 3840,\n" +
                                "            \"vigorousIntensityDurationInSeconds\": 2460,\n" +
                                "            \"floorsClimbed\": 1,\n" +
                                "            \"minHeartRateInBeatsPerMinute\": 56,\n" +
                                "            \"maxHeartRateInBeatsPerMinute\": 74,\n" +
                                "            \"averageHeartRateInBeatsPerMinute\": 73,\n" +
                                "            \"restingHeartRateInBeatsPerMinute\": 43,\n" +
                                "            \"timeOffsetHeartRateSamples\": {\n" +
                                "                \"3640\": 74,\n" +
                                "                \"8312\": 56,\n" +
                                "                \"11063\": 64,\n" +
                                "                \"16437\": 67,\n" +
                                "                \"19938\": 59\n" +
                                "            },\n" +
                                "            \"stepsGoal\": 7520,\n" +
                                "            \"pushesGoal\": 6240,\n" +
                                "            \"intensityDurationGoalInSeconds\": 6780,\n" +
                                "            \"floorsClimbedGoal\": 13,\n" +
                                "            \"averageStressLevel\": 38,\n" +
                                "            \"maxStressLevel\": 15,\n" +
                                "            \"stressDurationInSeconds\": 778,\n" +
                                "            \"restStressDurationInSeconds\": 118,\n" +
                                "            \"activityStressDurationInSeconds\": 61,\n" +
                                "            \"lowStressDurationInSeconds\": 55,\n" +
                                "            \"mediumStressDurationInSeconds\": 66,\n" +
                                "            \"highStressDurationInSeconds\": 60\n" +
                                "        }]}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void pushEpochsWebhook() throws Exception {
        mockMvc.perform(
                post("/garmin-api/push/epochs")
                        .header("user-agent", "Garmin Health API")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"epochs\": [\n" +
                                "    {\n" +
                                "      \"userId\": \"4aacafe82427c251df9c9592d0c06768\",\n" +
                                "      \"userAccessToken\": \"" + USER_TOKEN + "\",\n" +
                                "      \"summaryId\": \"x153a9f3-5a9478d4-6\",\n" +
                                "      \"activityType\": \"WALKING\",\n" +
                                "      \"activeKilocalories\": 24,\n" +
                                "      \"steps\": 93,\n" +
                                "      \"pushes\": 73,\n" +
                                "      \"distanceInMeters\": 49.11,\n" +
                                "      \"pushDistanceInMeters\": 34.43,\n" +
                                "      \"durationInSeconds\": 840,\n" +
                                "      \"activeTimeInSeconds\": 449,\n" +
                                "      \"startTimeInSeconds\": 1519679700,\n" +
                                "      \"startTimeOffsetInSeconds\": -21600,\n" +
                                "      \"met\": 3.3020337,\n" +
                                "      \"intensity\": \"ACTIVE\",\n" +
                                "      \"meanMotionIntensity\": 4,\n" +
                                "      \"maxMotionIntensity\": 7\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    void rejectsWrongUserAgent() throws Exception {
        mockMvc.perform(
                        post("/garmin-api/push/epochs")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{\n" +
                                        "  \"epochs\": [\n" +
                                        "    {\n" +
                                        "      \"userId\": \"4aacafe82427c251df9c9592d0c06768\",\n" +
                                        "      \"userAccessToken\": \"" + USER_TOKEN + "\",\n" +
                                        "      \"summaryId\": \"x153a9f3-5a9478d4-4\",\n" +
                                        "      \"activityType\": \"WALKING\",\n" +
                                        "      \"activeKilocalories\": 24,\n" +
                                        "      \"steps\": 93,\n" +
                                        "      \"pushes\": 73,\n" +
                                        "      \"distanceInMeters\": 49.11,\n" +
                                        "      \"pushDistanceInMeters\": 34.43,\n" +
                                        "      \"durationInSeconds\": 840,\n" +
                                        "      \"activeTimeInSeconds\": 449,\n" +
                                        "      \"startTimeInSeconds\": 1519679700,\n" +
                                        "      \"startTimeOffsetInSeconds\": -21600,\n" +
                                        "      \"met\": 3.3020337,\n" +
                                        "      \"intensity\": \"ACTIVE\",\n" +
                                        "      \"meanMotionIntensity\": 4,\n" +
                                        "      \"maxMotionIntensity\": 7\n" +
                                        "    }\n" +
                                        "  ]\n" +
                                        "}"))
                .andExpect(status().is4xxClientError());
    }
}
