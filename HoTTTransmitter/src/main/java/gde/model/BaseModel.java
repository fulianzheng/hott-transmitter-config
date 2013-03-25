package gde.model;

import java.util.List;
import java.util.Map;

abstract public class BaseModel {
	private int appVersion;
	private boolean autoTimerReset;
	private Switch autoTrimSwitch;
	private boolean bound;
	private List<Channel> channels;
	private List<Clock> clocks;
	private List<Control> controls;
	private DSCOutputType dscOutput;
	private ExtPPMType extPpmType;
	private int failSafeDelay;
	private boolean failSafeSettingCheck;
	private String info;
	private int memoryVersion;
	private List<Mixer> mixers;
	private String modelName;
	private int modelNumber;
	private final ModelType modelType;
	private HFModule module;
	private List<Phase> phases;
	private Switch powerOnWarning; // TODO check type
	private long receiverId;
	private StickMode stickMode;
	private Map<SwitchFunction, Switch> switches;
	private ThrottleCutOf throttleCutOf;
	private int throttleLastIdlePosition;
	private int throttleTrim;
	private long transmitterId;
	private TransmitterType transmitterType;
	private Vendor vendor;
	private TrainerConfig trainerConfig;
	private int voiceDelay;
	private SensorType sensorType;

	public BaseModel() {
		// required by JAXB
		this(ModelType.Unknown);
	}

	public BaseModel(final ModelType modelType) {
		this.modelType = modelType;
	}

	public int getAppVersion() {
		return appVersion;
	}

	public Switch getAutoTrimSwitch() {
		return autoTrimSwitch;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public List<Clock> getClocks() {
		return clocks;
	}

	public List<Control> getControls() {
		return controls;
	}

	public DSCOutputType getDscOutput() {
		return dscOutput;
	}

	public ExtPPMType getExtPpmType() {
		return extPpmType;
	}

	public int getFailSafeDelay() {
		return failSafeDelay;
	}

	public String getInfo() {
		return info;
	}

	public int getMemoryVersion() {
		return memoryVersion;
	}

	public List<Mixer> getMixers() {
		return mixers;
	}

	public String getModelName() {
		return modelName;
	}

	public int getModelNumber() {
		return modelNumber;
	}

	public ModelType getModelType() {
		return modelType;
	}

	public HFModule getModule() {
		return module;
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public Switch getPowerOnWarning() {
		return powerOnWarning;
	}

	public long getReceiverId() {
		return receiverId;
	}

	public StickMode getStickMode() {
		return stickMode;
	}

	public Map<SwitchFunction, Switch> getSwitches() {
		return switches;
	}

	public ThrottleCutOf getThrottleCutOf() {
		return throttleCutOf;
	}

	public int getThrottleLastIdlePosition() {
		return throttleLastIdlePosition;
	}

	public int getThrottleTrim() {
		return throttleTrim;
	}

	public long getTransmitterId() {
		return transmitterId;
	}

	public TransmitterType getTransmitterType() {
		return transmitterType;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public boolean isAutoTimerReset() {
		return autoTimerReset;
	}

	public boolean isBound() {
		return bound;
	}

	public boolean isFailSafeSettingCheck() {
		return failSafeSettingCheck;
	}

	public void setAppVersion(final int appVersion) {
		this.appVersion = appVersion;
	}

	public void setAutoTimerReset(final boolean autoTimerReset) {
		this.autoTimerReset = autoTimerReset;
	}

	public void setAutoTrimSwitch(final Switch autoTrimSwitch) {
		this.autoTrimSwitch = autoTrimSwitch;
	}

	public void setBound(final boolean bound) {
		this.bound = bound;
	}

	public void setChannels(final List<Channel> channels) {
		this.channels = channels;
	}

	public void setClocks(final List<Clock> clocks) {
		this.clocks = clocks;
	}

	public void setControls(final List<Control> controls) {
		this.controls = controls;
	}

	public void setDscOutput(final DSCOutputType dscOutput) {
		this.dscOutput = dscOutput;
	}

	public void setExtPpmType(final ExtPPMType extPpmType) {
		this.extPpmType = extPpmType;
	}

	public void setFailSafeDelay(final int failSafeDelay) {
		this.failSafeDelay = failSafeDelay;
	}

	public void setFailSafeSettingCheck(final boolean failSafeSettingCheck) {
		this.failSafeSettingCheck = failSafeSettingCheck;
	}

	public void setInfo(final String info) {
		this.info = info;
	}

	public void setMemoryVersion(final int memoryVersion) {
		this.memoryVersion = memoryVersion;
	}

	public void setMixers(final List<Mixer> mixers) {
		this.mixers = mixers;
	}

	public void setModelName(final String modelName) {
		this.modelName = modelName;
	}

	public void setModelNumber(final int modelNumber) {
		this.modelNumber = modelNumber;
	}

	public void setModule(final HFModule module) {
		this.module = module;
	}

	public void setPhases(final List<Phase> phases) {
		this.phases = phases;
	}

	public void setPowerOnWarning(final Switch powerOnWarning) {
		this.powerOnWarning = powerOnWarning;
	}

	public void setReceiverId(final long receiverId) {
		this.receiverId = receiverId;
	}

	public void setStickMode(final StickMode stickMode) {
		this.stickMode = stickMode;
	}

	public void setSwitches(final Map<SwitchFunction, Switch> switches) {
		this.switches = switches;
	}

	public void setThrottleCutOf(final ThrottleCutOf throttleCutOf) {
		this.throttleCutOf = throttleCutOf;
	}

	public void setThrottleLastIdlePosition(final int throttleLastPosition) {
		throttleLastIdlePosition = throttleLastPosition;
	}

	public void setThrottleTrim(final int throttleTrim) {
		this.throttleTrim = throttleTrim;
	}

	public void setTransmitterId(final long transmitterId) {
		this.transmitterId = transmitterId;
	}

	public void setTransmitterType(final TransmitterType transmitterType) {
		this.transmitterType = transmitterType;
	}

	public void setVendor(final Vendor vendor) {
		this.vendor = vendor;
	}

	public int getVoiceDelay() {
		return voiceDelay;
	}

	public void setVoiceDelay(final int voiceDelay) {
		this.voiceDelay = voiceDelay;
	}

	public SensorType getSensorType() {
		return sensorType;
	}

	public void setSensorType(final SensorType sensorType) {
		this.sensorType = sensorType;
	}

	public Switch getSwitch(final SwitchFunction function) {
		return getSwitches().get(function);
	}

	public void setSwitch(final SwitchFunction function, final Switch sw) {
		getSwitches().put(function, sw);
	}

	public TrainerConfig getTrainerConfig() {
		return trainerConfig;
	}

	public void setTrainerConfig(final TrainerConfig trainerConfig) {
		this.trainerConfig = trainerConfig;
	}
}